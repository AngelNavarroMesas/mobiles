package com.example.tarea32_angelnavarromesas

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tarea32_angelnavarromesas.databinding.GaleriasBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val galeria = GaleriasBinding.inflate(layoutInflater)
        setContentView(galeria.root)

        for (i in 0 until 5) {
            println(i)
        }

        galeria.vistaGalerias.adapter = GaleriasAdapter(listOf(

            Imagen("https://loremflickr.com/320/240?random=0"),
            Imagen("https://loremflickr.com/320/240?random=2"),
            Imagen("https://loremflickr.com/320/240?random=3"),
            Imagen("https://loremflickr.com/320/240?random=4"),
            Imagen("https://loremflickr.com/320/240?random=5"),
            Imagen("https://loremflickr.com/320/240?random=6"),
            Imagen("https://loremflickr.com/320/240?random=7"),
            Imagen("https://loremflickr.com/320/240?random=8"),
            Imagen("https://loremflickr.com/320/240?random=9"),
            Imagen("https://loremflickr.com/320/240?random=10"),
            Imagen("https://loremflickr.com/320/240?random=11"),
            Imagen("https://loremflickr.com/320/240?random=12"),
            Imagen("https://loremflickr.com/320/240?random=13"),
            Imagen("https://loremflickr.com/320/240?random=14"),
            Imagen("https://loremflickr.com/320/240?random=15"),
            Imagen("https://loremflickr.com/320/240?random=16"),
            Imagen("https://loremflickr.com/320/240?random=17"),
            Imagen("https://loremflickr.com/320/240?random=18"),
            Imagen("https://loremflickr.com/320/240?random=19"),
            Imagen("https://loremflickr.com/320/240?random=20")
        ))
    }
}