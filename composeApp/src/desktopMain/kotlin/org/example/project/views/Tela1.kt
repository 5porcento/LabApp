package org.example.project.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


import org.example.project.pdf.gerarPDF

@Composable
fun Tela1() {
    var nome by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("Preencha os dados e gere o PDF") }
    var checked by remember { mutableStateOf(false) }


    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState), // Permite rolar para baixo
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(
            value = nome, onValueChange = {nome = it}, label = { Text("Nome")}
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = idade, onValueChange = {idade = it}, label = { Text("Idade")}
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("Teste de Check BOX")
        Checkbox(
            checked = checked,
            onCheckedChange = {checked = it},

        )


        Button(onClick = {
            if (nome.isNotBlank() && idade.isNotBlank()){
                gerarPDF("Dados.pdf",nome,idade, checked = "Teste")
                status = "PDF gerado KRLL!!!"
            } else{
                status = "Preencha os campos"
            }
        }){
            Text("Gerar PDF")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(status)
    }
}