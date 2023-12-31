package com.example.juegonios

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.juegonios.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var mediaplayer: MediaPlayer? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val img = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        var perro = findViewById<ImageView>(R.id.imagenPerro);
        var rana = findViewById<ImageView>(R.id.imagenRana);
        var platano = findViewById<ImageView>(R.id.imagenPlatano);

        perro!!.setOnClickListener(this);

        rana!!.setOnClickListener(this);

        platano!!.setOnClickListener(this);

    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id){
                R.id.imagenPerro ->{
                    mediaplayer = MediaPlayer.create(this, R.raw.perro)
                    mediaplayer!!.start()
                }
                R.id.imagenRana ->{
                    mediaplayer = MediaPlayer.create(this, R.raw.rana)
                    mediaplayer!!.start()
                }
                R.id.imagenPlatano ->{
                    mediaplayer = MediaPlayer.create(this, R.raw.platano)
                    mediaplayer!!.start()
                }
            }
        }
    }
}