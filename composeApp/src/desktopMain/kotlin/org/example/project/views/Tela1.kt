package org.example.project.views

import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tela1(){
    val datePickerState = rememberDatePickerState()

    DatePicker(
        state = datePickerState,
        showModeToggle = false
    )

}
