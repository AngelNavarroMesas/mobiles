package com.example.piedrapapeltijerasjc

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.piedrapapeltijerasjc.ui.theme.PiedraPapelTijerasJCTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PiedraPapelTijerasJCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column (Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){

        Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = { /*TODO*/ },Modifier.width(width =125.dp).padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.piedra), contentDescription = "piedra")
            }
            Button(onClick = { /*TODO*/ },Modifier.width(width =125.dp).padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.papel), contentDescription = "papel")
            }
            Button(onClick = { /*TODO*/ },Modifier.width(width =125.dp).padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.tijeras), contentDescription = "tijeras")
            }
        }

        Row (Modifier.height(400.dp).fillMaxWidth()){}

        Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = { jugar(1) },Modifier.width(width =125.dp).padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.piedra), contentDescription = "piedra")
            }
            Button(onClick = { /*TODO*/ },Modifier.width(width =125.dp).padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.papel), contentDescription = "papel")
            }
            Button(onClick = { /*TODO*/ },Modifier.width(width =125.dp).padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.tijeras), contentDescription = "tijeras")
            }
        }
    }
}

fun jugar(jugador: Int){
    var bot: Int = Random.nextInt()*3;
    var texto: String="";

    if(jugador==bot){
        texto="Empate"
    }else if(jugador>bot){
        texto="Has ganado"
    }else if(jugador<bot){
        texto="has perdido"
    }
    var mensaje = Toast.makeText(this texto, Toast.LENGTH_SHORT) // in Activity
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PiedraPapelTijerasJCTheme {
        Greeting("Android")
    }
}