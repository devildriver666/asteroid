package com.udacity.asteroidradar.repository

import android.app.Application
import android.os.AsyncTask
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.database.AsteroidDAO
import kotlinx.coroutines.flow.Flow


class AsteroidRepository(private val asteroidDao: AsteroidDAO) {

    val allAsteroids: Flow<List<Asteroid>> = asteroidDao.getAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(asteroid: Asteroid) {
       // asteroidDao.insertAll(asteroid)
    }
}
