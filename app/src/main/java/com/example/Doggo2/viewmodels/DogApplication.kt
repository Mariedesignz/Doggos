package com.example.Doggo2.viewmodels

import android.app.Application
import com.example.Doggo2.database.AppDatabase


class DogApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}
