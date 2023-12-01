package com.example.examen

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examen.ui.theme.ExamenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenTheme { // Aply the theme, but it doesn't work correctly
                // Create the navController
                val navController = rememberNavController()
                val context = LocalContext.current
                val dao = ViewModel(context.applicationContext as Application).database
                val modifier = Modifier
                // Define the routes
                NavHost(
                    navController = navController,
                    startDestination = "Configuracion" // First screen
                ) {
                    composable(route = "Configuracion") { // List of Contacts screen
                        Configuracion(
                            navController,
                            modifier
                        )
                    }
                    composable(route = "ListaVacas") { // Create Contact screen
                        ListaVacas(
                            navController,
                            dao.Dao(),
                            context
                        )
                    }
                }
            }
        }
    }
}
