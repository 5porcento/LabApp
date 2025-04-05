package org.example.project.views

import FichaAnaliseViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.models.Views

@Composable
fun App(){
    var currentScreen by remember { mutableStateOf<Views>(Views.Home) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)){
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { currentScreen = Views.Home }) { Text("Home") }
            Button(onClick = {currentScreen = Views.Tela1}) { Text("Tela 1") }
            Button(onClick = {currentScreen = Views.Tela2}) { Text("Tela 2") }
        }

        Spacer(modifier = Modifier.height(16.dp))


        when (currentScreen){
            is Views.Home -> Home()
             Views.Tela1 -> Tela1()
            Views.Tela2 -> Tela2()
        }

    }
}