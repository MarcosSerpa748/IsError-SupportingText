package com.example.iserrorsupportingtext.data.banco

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.iserrorsupportingtext.data.dao.UsuarioDao
import com.example.iserrorsupportingtext.data.entity.UsuarioEntity

@Database(entities = [UsuarioEntity::class],version = 1)
abstract class BancoApp(): RoomDatabase(){

    abstract fun retornarUsuarioDao(): UsuarioDao
}