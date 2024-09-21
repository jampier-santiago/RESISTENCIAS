package com.example.clasekotlin.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable //Describe el estado actual de la UI
@Preview(showBackground = true) //Permite la previsualizacion del codigo
fun EjemploText(){
    Column (
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Texto Simple",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Texto con tamaño personalizado",
            fontSize = 20.sp
        )

        Text(
            text = "Texto en negrita",
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Texto en cursiva",
            fontStyle = FontStyle.Italic
        )

        Text(
            text = "Texto subrayado",
            textDecoration = TextDecoration.Underline
        )

        Text(
            text = "Texto centrado",
            textAlign = TextAlign.Center
        )

        Text(
            text = "Texto en color rojo",
            color = Color.Red
        )

        Text(
            text = "Texto con estilo de tema",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
