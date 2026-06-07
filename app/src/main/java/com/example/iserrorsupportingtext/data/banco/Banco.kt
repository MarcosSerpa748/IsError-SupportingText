package com.example.iserrorsupportingtext.data.banco

import android.content.Context
import androidx.room.Room
import com.example.iserrorsupportingtext.data.dao.UsuarioDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Banco{

    @Provides
    @Singleton
    fun gerarBanco(@ApplicationContext contexto: Context): BancoApp{
        return Room.databaseBuilder(
            context = contexto,
            klass = BancoApp::class.java,
            name = "banco"
        ).build()
    }

    @Provides
    fun gerarUsuarioDao(banco: BancoApp): UsuarioDao{
        return banco.retornarUsuarioDao()
    }
}