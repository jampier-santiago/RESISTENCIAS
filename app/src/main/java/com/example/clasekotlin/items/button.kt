package com.example.clasekotlin.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun BotonesEjemplo(){
    //Variable de estado
    val textoIngresado = remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            TextField(
                value = textoIngresado.value,
                onValueChange = { textoIngresado.value = it },
                placeholder = { Text("Escribe tu nombre aqui: ") },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                //.width(80.dp)
            )
        }

        item {
            Button(
                onClick = {
                    textoIngresado.value = "Kotlin"
                },
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text("Boton 1")
            }
        }

        item {
            Button(
                onClick = {
                    textoIngresado.value = "Java"
                },
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text("Boton 2")
            }
        }

        item {
            Text(
                text = textoIngresado.value,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        item {
            EjemploText()
        }
    }

}