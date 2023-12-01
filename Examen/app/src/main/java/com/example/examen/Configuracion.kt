package com.example.examen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Configuracion(navController: NavController, modifier: Modifier){

    var numVacas by rememberSaveable {
        mutableStateOf("")
    }
    var litrosIndividuales by remember {
        mutableStateOf("")
    }

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Numero vacas en la nave")
        TextField(value = numVacas, onValueChange = {numVacas = it})
        Text(text = "Litros de leche cada vaca")
        TextField(value = litrosIndividuales, onValueChange = {litrosIndividuales = it})
        Button(onClick = {navController.navigate("ListaVacas")}) {
            Text(text = "Lista vacas")
        }
    }
}