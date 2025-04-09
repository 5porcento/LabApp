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
import org.example.project.viewModels.PdfPost
import org.example.project.models.*
import org.example.project.viewModels.formatarData

@Composable
fun Home() {
    var nomeAluno by remember { mutableStateOf("") }
    var fone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nomeProjeto by remember { mutableStateOf("") }
    var localColeta by remember { mutableStateOf("") }
    var dataColeta by remember { mutableStateOf("") }
    var responsalvelColeta by remember { mutableStateOf("") }
    var numeroAmostra by remember { mutableStateOf("") }
    val opcoesLista = remember { mutableStateListOf<String>() }

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState), // Permite rolar para baixo
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(
            value = nomeAluno, onValueChange = {nomeAluno = it}, label = { Text("Nome")}
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = fone, onValueChange = { fone = it}, label = { Text("Fone")}
        )

        OutlinedTextField(
            value = email, onValueChange = { email = it}, label = { Text("Email")}
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = nomeProjeto, onValueChange = { nomeProjeto = it}, label = { Text("Nome Do Projeto")}
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = localColeta, onValueChange = { localColeta = it}, label = { Text("Local da Coleta")}
        )
        Spacer(modifier = Modifier.height(10.dp))
       OutlinedTextField(
            value = dataColeta,
            onValueChange = { newValue ->
                dataColeta = formatarData(newValue)
            },
            label = { Text("Data Coleta") },
            placeholder = { Text("dd/MM/yyyy") }
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = responsalvelColeta, onValueChange = { responsalvelColeta = it}, label = { Text("Responsavel pela Coleta")}
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = numeroAmostra, onValueChange = { numeroAmostra = it}, label = { Text("Numero de Amostras")}
        )
        Spacer(modifier = Modifier.height(10.dp))

        // Criando as checkboxes para cada opção disponível
        lista.forEach { opcao ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = opcao in opcoesLista,
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            opcoesLista.add(opcao)
                        } else {
                            opcoesLista.remove(opcao)
                        }
                    }
                )
                Text(opcao)
            }
        }
        Button(onClick = {
            PdfPost(nomeAluno,opcoesLista.toList())
        }) {
            Text("Gerar PDF")
        }
    }
}
