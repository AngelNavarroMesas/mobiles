package com.example.pptjcbasedatos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController, modifier: Modifier){
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Row {
            Text(text = "Nombre")
            var text by remember { mutableStateOf("") }
            TextField(value = text, onValueChange = { text = it })
        }
        Button(onClick = {}) {
            Text(text = "Jugar")
        }
    }
}