package com.example.multimediajpc

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.multimediajpc.ui.theme.MultimediaJPCTheme
import java.io.IOException

var mediaplayer = MediaPlayer? = null

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mediaplayer = MediaPlayer.create(this.R.raw.platano.mp3)
        setContent {
            MultimediaJPCTheme {
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
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Button(onClick = {
        if (mediaplayer!!.isPlaying){
            try {
                mediaplayer!!.stop()
                mediaplayer!!.prepare()
                mediaplayer!!.seekTo(0)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }else{
            mediaplayer!!.start()
        }
    }) {
        Text(text = "Musica")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MultimediaJPCTheme {
        Greeting("Android")
    }
}