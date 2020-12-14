package com.udacity.asteroidradar.repository

import androidx.annotation.WorkerThread
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.AsteroidEntity
import com.udacity.asteroidradar.database.AsteroidDAO
import kotlinx.coroutines.flow.Flow

class AsteroidRepository(private val asteroidDao: AsteroidDAO) {

    val allAsteroids: Flow<List<AsteroidEntity>> = asteroidDao.getAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(asteroid: AsteroidEntity) {
       // asteroidDao.insertAll(asteroid)
    }
}