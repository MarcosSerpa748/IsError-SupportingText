package com.example.iserrorsupportingtext.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Usuarios")
data class UsuarioEntity(
    @PrimaryKey(autoGenerate = true)val id:Long = 0,
    val nome:String,
    val idade:String
)