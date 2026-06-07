package com.example.iserrorsupportingtext.domain.usecase

import com.example.iserrorsupportingtext.data.repository.UsuarioRepository
import javax.inject.Inject

class InserirUsuarioUseCase@Inject constructor(private val repositorio: UsuarioRepository){

    suspend operator fun invoke(nome:String,idade: String){

        if (nome.isBlank()){
            throw Exception("O campo de nome está vazio!")
        }
        if (idade.isBlank()){
            throw Exception("O campo de idade está vazio!")
        }

        repositorio.inserirUsuario(nome = nome,idade = idade)
    }
}