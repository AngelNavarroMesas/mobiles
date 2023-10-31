package com.example.piedrapapeltijerasjc

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
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

//Estas son las variables:
//estas dos son para identificar la eleccion del jugador y la maquina
var jugador = 0
var bot=0
//Estas dos cuentan los puntos de cada uno
var puntosJug = 0
var puntosBot = 0
//cuenta el turno por el que va la partida
var partida = 0


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context= LocalContext.current

    Column (Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        //Estas son las tres elecciones de la maquina, las he puesto en botones en caso de que haya que hacer una version pvp pero no hacen nada, es solo estetico
        Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = { /*TODO*/ },
                Modifier
                    .width(width = 125.dp)
                    .padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.piedra), contentDescription = "piedra")
            }
            Button(onClick = { /*TODO*/ },
                Modifier
                    .width(width = 125.dp)
                    .padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.papel), contentDescription = "papel")
            }
            Button(onClick = { /*TODO*/ },
                Modifier
                    .width(width = 125.dp)
                    .padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.tijeras), contentDescription = "tijeras")
            }
        }

        //Esta fila mostraria la eleccion de cada jugador pero no he conseguido hacer que funcione la funcion
        Row (Modifier.height(400.dp).fillMaxWidth()){ /*mostrarEleccion()*/}

        //Estas son las elecciones del jugador, cada una es un boton con una imagen indicando si es piedra, papel o tijeras
        Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            Button(onClick = { jugador=1; turno(context) },
                Modifier
                    .width(width = 125.dp)
                    .padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.piedra), contentDescription = "piedra")
            }
            Button(onClick = { jugador=2; turno(context) },
                Modifier
                    .width(width = 125.dp)
                    .padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.papel), contentDescription = "papel")
            }
            Button(onClick = { jugador=3; turno(context) },
                Modifier
                    .width(width = 125.dp)
                    .padding(5.dp)) {
                Image(painter = painterResource(id = R.drawable.tijeras), contentDescription = "tijeras")
            }
        }
    }

}

//Esta es la funcion que deberia mostrar las imagenes en el centro
//@Composable
//fun mostrarEleccion() {
//    if (jugador == 1){
//        Image(painter = painterResource(id = R.drawable.piedra), contentDescription = "Elección 1", Modifier.width(width = 125.dp).padding(5.dp))
//    }else if (jugador == 2){
//        Image(painter = painterResource(id = R.drawable.papel), contentDescription = "Elección 2", Modifier.width(width = 125.dp).padding(5.dp))
//    }else{
//        Image(painter = painterResource(id = R.drawable.piedra), contentDescription = "Elección 3", Modifier.width(width = 125.dp).padding(5.dp))
//    }
//
//    if (bot == 1){
//        Image(painter = painterResource(id = R.drawable.piedra), contentDescription = "Máquina 1", Modifier.width(width = 125.dp).padding(5.dp))
//    }else if (bot == 2){
//        Image(painter = painterResource(id = R.drawable.papel), contentDescription = "Máquina 2", Modifier.width(width = 125.dp).padding(5.dp))
//    }else{
//        Image(painter = painterResource(id = R.drawable.tijeras), contentDescription = "Máquina 3", Modifier.width(width = 125.dp).padding(5.dp))
//    }
//}

//Esta funcion muestra los resultados de cada turno y de la partida en general
fun turno(context: Context){
    //Hacemos que la maquina haga una eleccion aleatoria
    bot= Random.nextInt(1,4);
    var texto: String="";

    //Comprobamos quien ha ganado, en caso de empate no cuenta como que ha pasado un turno
    if(jugador==bot){
        texto="Empate"
    }else if(jugador==1&&bot==3||jugador==2&&bot==1||jugador==3&&bot==2){
        texto="Has ganado"
        puntosJug ++
        partida++
    }else if(jugador==3&&bot==1||jugador==1&&bot==2||jugador==2&&bot==3){
        texto="has perdido"
        puntosBot ++
        partida++
    }

    //comprobamos si se termina la partida, si han pasado 5 turnos termina y muestra quien es el ganador reiniciando los puntos de los dos jugadores y el contador de turnos
    //y si no han pasado 5 turnos muestra el ganador de este turno
    if(partida!=5){
        Toast.makeText(context, texto, Toast.LENGTH_SHORT).show()
    }else if(puntosJug>puntosBot){
        Toast.makeText(context, "HAS GANADO LA PARTIDA!!!!  $puntosJug-$puntosBot", Toast.LENGTH_SHORT).show()
        partida=0
        puntosJug=0
        puntosBot=0
    }else{
        Toast.makeText(context, "Has perdido la partida...  $puntosJug-$puntosBot", Toast.LENGTH_SHORT).show()
        partida=0
        puntosJug=0
        puntosBot=0
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PiedraPapelTijerasJCTheme {
        Greeting("Android")
    }
}