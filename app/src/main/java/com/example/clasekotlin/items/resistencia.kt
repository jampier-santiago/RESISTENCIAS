package com.example.clasekotlin.items

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.pow
import java.text.DecimalFormat

val colores = listOf("Negro", "Marrón", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Violeta", "Gris", "Blanco")

@Preview(showBackground = true)
@Composable
fun Interfaz() {
    var banda1 by remember { mutableStateOf(colores[0]) }
    var banda2 by remember { mutableStateOf(colores[0]) }
    var multiplicador by remember { mutableStateOf(colores[0]) }
    var resistencia by remember { mutableStateOf("0 Ω") }

    // Función para formatear la resistencia con separador de miles
    fun formatearResistencia(valor: Double): String {
        val formatter = DecimalFormat("#,###") // Formato con separador de miles
        return if (valor % 1.0 == 0.0) {
            "${formatter.format(valor.toInt())} Ω" // Mostrar como entero si no tiene decimales
        } else {
            "${formatter.format(valor)} Ω" // Mostrar con decimales si es necesario
        }
    }

    // Función para calcular la resistencia
    fun calcularResistencia() {
        val valorBanda1 = colores.indexOf(banda1) * 10
        val valorBanda2 = colores.indexOf(banda2)
        val valorMultiplicador = 10.0.pow(colores.indexOf(multiplicador).toDouble())
        val resultado = (valorBanda1 + valorBanda2) * valorMultiplicador

        resistencia = formatearResistencia(resultado)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center) // Centramos todo el contenido
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DropdownSelector("Selecciona Banda 1", banda1) { nuevoValor ->
            banda1 = nuevoValor
            calcularResistencia()
        }

        DropdownSelector("Selecciona Banda 2", banda2) { nuevoValor ->
            banda2 = nuevoValor
            calcularResistencia()
        }

        DropdownSelector("Selecciona Multiplicador", multiplicador) { nuevoValor ->
            multiplicador = nuevoValor
            calcularResistencia()
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Resistencia: $resistencia", style = MaterialTheme.typography.headlineMedium)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownSelector(
    label: String,
    selectedValue: String,
    onValueChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(label, style = MaterialTheme.typography.bodyLarge)
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selectedValue,
                onValueChange = {},
                readOnly = true,
                modifier = Modifier.menuAnchor(),
                label = { Text(label) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                colores.forEach { color ->
                    DropdownMenuItem(
                        text = { Text(color) },
                        onClick = {
                            onValueChange(color)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}