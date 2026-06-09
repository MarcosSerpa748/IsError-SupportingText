package com.example.iserrorsupportingtext.domain.usecase

import com.example.iserrorsupportingtext.data.repository.UsuarioRepository
import java.lang.IllegalArgumentException
import javax.inject.Inject

class InserirUsuarioUseCase@Inject constructor(private val repositorio: UsuarioRepository){

    suspend operator fun invoke(nome:String,idade: String){

        if (nome.isBlank()){
            throw IllegalArgumentException("O campo de nome está vazio!")
        }
        if (idade.isBlank()){
            throw IllegalStateException("O campo de idade está vazio!")
        }

        repositorio.inserirUsuario(nome = nome,idade = idade)
    }
}