package com.example.agendajc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItemList(
                itemContacto = listOf(
                    Contacto("Juan Jameson Jr", "611123456", true),
                    Contacto("Maria Martinez Mendoza", "678456123", false),
                    Contacto("Raúl Romero Rodriguez", "611126123", true),
                    Contacto("Antonio Aguilar Alcantara", "611123456", true),
                    Contacto("Ana Alvarez Agramonte", "678456123",false),
                    Contacto("Paco Perez Parker", "611126123", true),
                    Contacto("Juan Jameson Jr", "611123456", true),
                    Contacto("Maria Martinez Mendoza", "678456123", false),
                    Contacto("Raúl Romero Rodriguez", "611126123", true),
                    Contacto("Antonio Aguilar Alcantara", "611123456", true),
                    Contacto("Ana Alvarez Agramonte", "678456123",false),
                    Contacto("Paco Perez Parker", "611126123", true),
                    Contacto("Juan Jameson Jr", "611123456", true),
                    Contacto("Maria Martinez Mendoza", "678456123", false),
                    Contacto("Raúl Romero Rodriguez", "611126123", true),
                    Contacto("Antonio Aguilar Alcantara", "611123456", true),
                    Contacto("Ana Alvarez Agramonte", "678456123",false),
                    Contacto("Paco Perez Parker", "611126123", true),
                    Contacto("Juan Jameson Jr", "611123456", true),
                    Contacto("Maria Martinez Mendoza", "678456123", false),
                    Contacto("Raúl Romero Rodriguez", "611126123", true),
                    Contacto("Antonio Aguilar Alcantara", "611123456", true),
                    Contacto("Ana Alvarez Agramonte", "678456123",false),
                    Contacto("Paco Perez Parker", "611126123", true),
                    Contacto("Juan Jameson Jr", "611123456", true),
                    Contacto("Maria Martinez Mendoza", "678456123", false),
                    Contacto("Raúl Romero Rodriguez", "611126123", true),
                    Contacto("Antonio Aguilar Alcantara", "611123456", true),
                    Contacto("Ana Alvarez Agramonte", "678456123",false),
                    Contacto("Paco Perez Parker", "611126123", true)
                )
            )
        }
    }

    @Composable
    fun ItemList(itemContacto: List<Contacto>) {
        LazyColumn {
            items(itemContacto) { itemContacto ->
                ContactoView(contacto = itemContacto)
            }
        }
    }

    @Composable
    fun ContactoView(contacto: Contacto){
        Card(Modifier.fillMaxWidth()){
            Row {
                Column {
                    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Foto contacto", Modifier.height(100.dp))
                }
                Column {
                    Text(text = contacto.nombre,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = contacto.tfno,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}