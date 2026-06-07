package com.example.iserrorsupportingtext.domain.uiState

data class TelaCadastroUIState(
    val nome:String = "",
    val idade:String = "",
    val erro:Boolean = false,
    val mensagemErro:String = ""
)