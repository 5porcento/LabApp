package org.example.project.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Tela1() {
   //TODO Aqui vai as variaveis dos campos do pdf
    var nomeCliente by remember { mutableStateOf("") }



    val scrollState = rememberScrollState()
    // TODO adicionar os campos
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState), // Permite rolar para baixo
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(
            //TODO adiconar o nome da variavel nos dois lugares, value e onValueChange, ai depois troca o Texte, pro nome
            value = nomeCliente, onValueChange = {nomeCliente = it}, label = { Text("Nome Cliente") }
        )
        Spacer(modifier = Modifier.height(10.dp))

        //TODO adicionar os OutlinedTextField e Spacer dos campos que tu vai adicionar
       // TODO lembra de mudar o nome das value e onValueChange

    }

}

