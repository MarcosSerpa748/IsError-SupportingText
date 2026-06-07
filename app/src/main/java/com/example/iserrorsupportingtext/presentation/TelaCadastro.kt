package com.example.iserrorsupportingtext.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.iserrorsupportingtext.domain.viewModel.TelaCadastroViewModel

@Composable
fun TelaCadastro(viewModel: TelaCadastroViewModel = hiltViewModel()){

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        OutlinedTextField(
            value = uiState.nome,
            onValueChange = {viewModel.alterarNome(it)},
            label = {Text(text = "Seu nome:")},
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedLabelColor = Color.Black,
                cursorColor = Color.Black,
                focusedLabelColor = Color.Black,
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black),
            isError = uiState.erro,
            supportingText = {
                if (uiState.erro){
                    Text(text = uiState.mensagemErro)
                }
            })

        OutlinedTextField(
            value = uiState.idade,
            onValueChange = {viewModel.alterarIdade(it)},
            label = {Text(text = "Sua idade:")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedLabelColor = Color.Black,
                cursorColor = Color.Black,
                focusedLabelColor = Color.Black,
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black),
            isError = uiState.erro,
            supportingText = {
                if (uiState.erro)
                    Text(text = uiState.mensagemErro)
            })

        Button(onClick = {viewModel.cadastrarUsuario()}){
            Text(text = "Cadastrar")
            Icon(imageVector = Icons.Filled.Check, contentDescription = null)
        }
    }
}