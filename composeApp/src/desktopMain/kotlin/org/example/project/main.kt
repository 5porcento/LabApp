package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.project.views.Home
import org.example.project.views.Tela1
import org.example.project.views.Tela2


sealed class Views{
    object Home : Views()
    object Tela1 : Views()
    object Tela2 : Views()
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "LabAPp",
    ) {
        App()
    }
}

@Composable
fun App(){
    var currentScreen by remember { mutableStateOf<Views>(Views.Home) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)){
     Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
         Button(onClick = { currentScreen = Views.Home }) { Text("Home") }
         Button(onClick = {currentScreen = Views.Tela1}) { Text("Tela 1")}
         Button(onClick = {currentScreen = Views.Tela2}) { Text("Tela 2")}
     }

        Spacer(modifier = Modifier.height(16.dp))

        when (currentScreen){
            is Views.Home -> Home()
            Views.Tela1 -> Tela1()
            Views.Tela2 -> Tela2()
        }

    }
}