package com.example.piedrapapeltijerasjc

import android.os.Bundle
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
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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
            Button(onClick = {/*TODO*/}, Modifier.padding(10.dp)) {
                Image(painter = painterResource(id = R.drawable.piedra), contentDescription = "piedra")
            }
            Button(onClick = {/*TODO*/}) {
                Image(painter = painterResource(id = R.drawable.papel), contentDescription = "papel")
            }
            Button(onClick = {/*TODO*/} ) {
                Image(painter = painterResource(id = R.drawable.tijeras), contentDescription = "tijeras")
            }
        }

        Row (Modifier.height(300.dp).fillMaxWidth()){}

        Row (Modifier.fillMaxWidth()){
            Button(onClick = { /*TODO*/ },Modifier.width(width =100.dp).padding(10.dp)) {
                Image(painter = painterResource(id = R.drawable.piedra), contentDescription = "piedra")
            }
            Button(onClick = { /*TODO*/ },Modifier.width(width =100.dp).padding(10.dp)) {
                Image(painter = painterResource(id = R.drawable.papel), contentDescription = "papel")
            }
            Button(onClick = { /*TODO*/ },Modifier.width(width =100.dp).padding(10.dp)) {
                Image(painter = painterResource(id = R.drawable.tijeras), contentDescription = "tijeras")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PiedraPapelTijerasJCTheme {
        Greeting("Android")
    }
}