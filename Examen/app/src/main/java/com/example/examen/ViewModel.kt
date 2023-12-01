package com.example.examen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.room.Room

class ViewModel(application: Application) : ViewModel() {
    val database: VacasDatabase by lazy {
        Room.databaseBuilder(
            application,
            VacasDatabase::class.java,
            "Contactos"
        ).build()
    }
}