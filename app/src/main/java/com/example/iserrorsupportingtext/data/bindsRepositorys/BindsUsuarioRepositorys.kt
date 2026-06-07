package com.example.iserrorsupportingtext.data.bindsRepositorys

import com.example.iserrorsupportingtext.data.repository.UsuarioRepositorioimpl
import com.example.iserrorsupportingtext.data.repository.UsuarioRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsUsuarioRepositorys{

    
    @Binds
    abstract fun retornarImplementacao(implementacao: UsuarioRepositorioimpl): UsuarioRepository
}