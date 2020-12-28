package com.udacity.asteroidradar.database

import android.content.Context
import androidx.room.*
import com.udacity.asteroidradar.Asteroid


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow


@Dao
interface AsteroidDAO {
    @Query("SELECT * FROM asteroid_table")
    fun getAll(): Flow<List<Asteroid>>

//    @Insert
//    fun insertAll(vararg asteroids: Asteroid)
//    suspend fun insert(asteroids: Asteroid)
}



