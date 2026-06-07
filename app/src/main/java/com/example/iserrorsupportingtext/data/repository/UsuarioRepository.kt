package com.example.iserrorsupportingtext.data.repository

interface UsuarioRepository{

    suspend fun inserirUsuario(nome:String,idade:String)
}