package com.example.galeria2_angelnavarromesas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.galeria2_angelnavarromesas.databinding.ImagenesBinding

class MainActivity : AppCompatActivity() {

    private lateinit var pCompleta: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imagenes = ImagenesBinding.inflate(layoutInflater)
        setContentView(imagenes.root)

        val listaImagenes = mutableListOf<Imagen>()

        for (i in 0 until 30) {
            val random = (0..100).random()
            val urlFoto = "https://loremflickr.com/320/240?random=$random"
            val foto = Imagen(urlFoto)
            listaImagenes.add(foto)
        }

        val recyclerView: RecyclerView = findViewById(R.id.vistaImagenes)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        recyclerView.adapter = GaleriaAdapter(listaImagenes, this::abrirFoto)
        pCompleta = findViewById(R.id.panCompleta)

        pCompleta.setOnClickListener {
            cerrarFoto()
        }
    }

    private fun abrirFoto(urlFoto: String) {
        pCompleta.visibility = View.VISIBLE
        Glide.with(this)
            .load(urlFoto)
            .into(pCompleta)
    }

    private fun cerrarFoto() {
        pCompleta.visibility = View.GONE
    }

}