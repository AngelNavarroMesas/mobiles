package com.example.pptjcbasedatos

import android.content.Context
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pptjcbasedatos.entidades.JugadorEntity
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

var nombreJugador = ""
var jugador = 0
var bot=0
//Estas dos cuentan los puntos de cada uno
var puntosJugador = 0
var puntosBot = 0
//cuenta el turno por el que va la partida
var partida = 0
lateinit var jugadores: MutableList<JugadorEntity>

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController, modifier: Modifier){
    getAllJugadores()

    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Row {
            Text(text = "Nombre")
            var text by remember { mutableStateOf("") }
            TextField(value = text, onValueChange = { text = it })
        }
        Button(onClick = {navController.navigate("juego")}) { Text(text = "Jugar")
        }
    }
}

@Composable
fun Juego(navController: NavController, modifier: Modifier){
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
        Row (
            Modifier
                .height(400.dp)
                .fillMaxWidth()){ /*mostrarEleccion()*/}

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

fun turno(context: Context){
    //Hacemos que la maquina haga una eleccion aleatoria
    bot= Random.nextInt(1,4);
    var texto ="";

    //Comprobamos quien ha ganado, en caso de empate no cuenta como que ha pasado un turno
    if(jugador==bot){
        texto="Empate"
    }else if(jugador==1&&bot==3||jugador==2&&bot==1||jugador==3&&bot==2){
        texto="Has ganado"
        partida++
    }else if(jugador==3&&bot==1||jugador==1&&bot==2||jugador==2&&bot==3){
        texto="has perdido"
        puntosBot++
        partida++
    }

    //comprobamos si se termina la partida, si han pasado 5 turnos termina y muestra quien es el ganador reiniciando los puntos de los dos jugadores y el contador de turnos
    //y si no han pasado 5 turnos muestra el ganador de este turno
    if(puntosBot!=3){
        Toast.makeText(context, texto, Toast.LENGTH_SHORT).show()
    }else{
        puntosJugador= partida-puntosBot
        Toast.makeText(context, "Ha terminado la partida puntuacion: $puntosJugador", Toast.LENGTH_SHORT).show()
        //addJugador(JugadorEntity())
        partida=0
        puntosBot=0
    }
}


fun getAllJugadores()= runBlocking {       // Corrutina que saca de la base de datos la lista de tareas
    launch {                        // Inicio del hilo
        jugadores = HighScoreApp.database.JugadorDao().getAllJugadores()    // Se carga la lista de tareas

    }
}

fun addJugador(task:JugadorEntity)= runBlocking{  // Corrutina que añade una tarea a la lista
    launch {
        val id = HighScoreApp.database.JugadorDao().addJugador(task)   // Inserta una tarea nueva
        val recoveryTask = HighScoreApp.database.JugadorDao().getJugadorById(id)   // Recarga la lista
        jugadores.add(recoveryTask) // Añade al final de la lista, el nuevo
    }
}

fun updateTask(task: JugadorEntity) = runBlocking{
    launch {
        HighScoreApp.database.JugadorDao().updateJugador(JugadorEntity()) // Actualiza en la base de datos
    }
}

fun deleteTask(task: JugadorEntity)= runBlocking{
    launch {
        HighScoreApp.database.JugadorDao().deleteJugador(task) // ... y la borra de la base de datos.
        jugadores.remove(task)      // Finalmente, la elimina de la lista
    }
}