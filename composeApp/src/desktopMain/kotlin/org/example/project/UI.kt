package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun iApp() {
    var nome by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("Preencha os dados e gere o PDF") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        OutlinedTextField(
            value = nome,
            onValueChange = {nome = it},
            label = { Text("Nome")}
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = idade,
            onValueChange = {idade = it},
            label = { Text("Idade")}
        )

        Button(onClick = {
            if (nome.isNotBlank() && idade.isNotBlank()){
                gerarPDF("Dados.pdf",nome,idade)
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