package com.example.iserrorsupportingtext.domain.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iserrorsupportingtext.domain.uiState.TelaCadastroUIState
import com.example.iserrorsupportingtext.domain.usecase.InserirUsuarioUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import javax.inject.Inject

@HiltViewModel
class TelaCadastroViewModel@Inject constructor(private val inserirUsuarioUseCase: InserirUsuarioUseCase): ViewModel(){
    private val _nome = MutableStateFlow("")
    private val _idade = MutableStateFlow("")
    private val _erroCampoNome = MutableStateFlow(false)
    private val _erroCampoIdade = MutableStateFlow(false)
    private val _mensagemErro = MutableStateFlow("")

    val uiState = combine(
        _nome,
        _idade,
        _erroCampoNome,
        _erroCampoIdade,
        _mensagemErro
    ){nome,idade,erroCampoNome,erroCampoIdade,mensagemErro ->
        TelaCadastroUIState(nome = nome,idade = idade, erroCampoNome = erroCampoNome, erroCampoIdade = erroCampoIdade,mensagemErro = mensagemErro)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = TelaCadastroUIState()
    )

    fun alterarNome(valor:String){
        _nome.value = valor
    }
    fun alterarIdade(valor:String){
        _idade.value = valor
    }

    fun cadastrarUsuario(){
        viewModelScope.launch {
            try {
                inserirUsuarioUseCase(nome = _nome.value,idade = _idade.value)
                alterarNome("")
                alterarIdade("")
                _erroCampoNome.value = false
                _erroCampoIdade.value = false
                _mensagemErro.value = ""

            }catch (e: IllegalArgumentException){
                _erroCampoNome.value = true
                _mensagemErro.value = "${e.message}"
                _erroCampoIdade.value = false

            }catch(e: IllegalStateException){
                _erroCampoIdade.value = true
                _mensagemErro.value = "${e.message}"
                _erroCampoNome.value = false
            }
        }
    }
}