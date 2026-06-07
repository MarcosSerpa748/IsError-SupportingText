package com.example.iserrorsupportingtext.data.repository

import com.example.iserrorsupportingtext.data.dao.UsuarioDao
import com.example.iserrorsupportingtext.data.entity.UsuarioEntity
import javax.inject.Inject


class UsuarioRepositorioimpl@Inject constructor(private val dao: UsuarioDao): UsuarioRepository{

    override suspend fun inserirUsuario(nome: String, idade: String){

        val usuario = UsuarioEntity(nome = nome, idade = idade)
        dao.inserirUsuario(usuario)
    }

}