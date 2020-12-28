package com.udacity.asteroidradar

import android.app.Application
import com.udacity.asteroidradar.database.AsteroidDatabase

import com.udacity.asteroidradar.repository.AsteroidRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


    class AsteroidApplication : Application() {

        val applicationScope = CoroutineScope(SupervisorJob())
        // Using by lazy so the database and the repository are only created when they're needed
        // rather than when the application starts
        val database by lazy { AsteroidDatabase.getDatabase(this, applicationScope) }
        val repository by lazy { AsteroidRepository(database.asteroidDao()) }
    }
