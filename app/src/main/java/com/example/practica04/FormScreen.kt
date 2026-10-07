package com.example.practica04

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica04.components.CustomCheckbox
import com.example.practica04.components.CustomDatePicker
import com.example.practica04.components.CustomRadioButton
import com.example.practica04.components.CustomSpinner
import com.example.practica04.components.CustomSwitch

@Composable
fun FormScreen() {

    var notificaciones by remember {
        mutableStateOf(false)
    }

    var modalidad by remember {
        mutableStateOf("Presencial")
    }

    var aceptaTerminos by remember {
        mutableStateOf(false)
    }

    var nivel by remember {
        mutableStateOf("Seleccionar opción")
    }

    var fecha by remember {
        mutableStateOf("")
    }

    var resultado by remember {
        mutableStateOf("")
    }

    val rosa = Color(0xFFE75480)
    val rosaClaro = Color(0xFFFFF0F5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(rosaClaro)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Práctica 04",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = rosa,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = "Controles Avanzados",
            fontSize = 18.sp,
            color = Color.DarkGray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                // 1. SWITCH
                Text(
                    text = "1. Switch",
                    fontWeight = FontWeight.Bold,
                    color = rosa
                )

                CustomSwitch(
                    isChecked = notificaciones,
                    onCheckedChange = {
                        notificaciones = it
                    }
                )

                HorizontalDivider()

                // 2. RADIOBUTTON
                Text(
                    text = "2. Modalidad",
                    fontWeight = FontWeight.Bold,
                    color = rosa
                )

                CustomRadioButton(
                    selectedOption = modalidad,
                    onOptionSelected = {
                        modalidad = it
                    }
                )

                HorizontalDivider()

                // 3. CHECKBOX
                Text(
                    text = "3. Términos y condiciones",
                    fontWeight = FontWeight.Bold,
                    color = rosa
                )

                CustomCheckbox(
                    isChecked = aceptaTerminos,
                    onCheckedChange = {
                        aceptaTerminos = it
                    }
                )

                HorizontalDivider()

                // 4. SPINNER
                Text(
                    text = "4. Nivel de experiencia",
                    fontWeight = FontWeight.Bold,
                    color = rosa
                )

                CustomSpinner(
                    selectedOption = nivel,
                    onOptionSelected = {
                        nivel = it
                    }
                )

                HorizontalDivider()

                // 5. DATEPICKER
                Text(
                    text = "5. Fecha del evento",
                    fontWeight = FontWeight.Bold,
                    color = rosa
                )

                CustomDatePicker(
                    selectedDate = fecha,
                    onDateSelected = {
                        fecha = it
                    }
                )
            }
        }

        Button(
            onClick = {

                resultado = """
                    Notificaciones: ${if (notificaciones) "Activadas" else "Desactivadas"}
                    Modalidad: $modalidad
                    Términos aceptados: ${if (aceptaTerminos) "Sí" else "No"}
                    Nivel de experiencia: $nivel
                    Fecha seleccionada: ${if (fecha.isEmpty()) "Sin seleccionar" else fecha}
                """.trimIndent()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = rosa
            ),
            shape = RoundedCornerShape(16.dp)
        ) {

            Text(
                text = "Procesar formulario",
                fontSize = 16.sp
            )
        }

        if (resultado.isNotEmpty()) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Resumen de información",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = rosa
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(
                        text = resultado,
                        fontSize = 16.sp
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )
    }
}