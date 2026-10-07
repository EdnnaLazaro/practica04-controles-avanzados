package com.example.practica04.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CustomRadioButton(
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    val opciones = listOf(
        "Presencial",
        "En línea"
    )

    Column {
        opciones.forEach { opcion ->

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    onOptionSelected(opcion)
                }
            ) {
                RadioButton(
                    selected = selectedOption == opcion,
                    onClick = {
                        onOptionSelected(opcion)
                    }
                )

                Text(
                    text = opcion
                )
            }
        }
    }
}