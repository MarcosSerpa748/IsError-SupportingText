package com.example.iserrorsupportingtext.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.iserrorsupportingtext.data.entity.UsuarioEntity

@Dao
interface UsuarioDao{

    @Insert
    suspend fun inserirUsuario(usuario: UsuarioEntity)
}