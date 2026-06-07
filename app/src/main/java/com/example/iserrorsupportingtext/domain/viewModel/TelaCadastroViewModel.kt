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
import javax.inject.Inject

@HiltViewModel
class TelaCadastroViewModel@Inject constructor(private val inserirUsuarioUseCase: InserirUsuarioUseCase): ViewModel(){
    private val _nome = MutableStateFlow("")
    private val _idade = MutableStateFlow("")
    private val _erro = MutableStateFlow(false)
    private val _mensagemErro = MutableStateFlow("")

    val uiState = combine(
        _nome,
        _idade,
        _erro,
        _mensagemErro
    ){nome,idade,erro,mensagemErro ->
        TelaCadastroUIState(nome = nome,idade = idade, erro = erro,mensagemErro = mensagemErro)
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
                _erro.value = false
                _mensagemErro.value = ""
            }catch (e: Exception){
                _erro.value = true
                _mensagemErro.value = "${e.message}"
            }
        }
    }
}