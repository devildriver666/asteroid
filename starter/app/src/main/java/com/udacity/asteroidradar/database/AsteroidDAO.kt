package com.udacity.asteroidradar.database

import android.content.Context
import androidx.room.*
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.AsteroidEntity

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow


@Dao
interface AsteroidDAO {
    @Query("SELECT * FROM word_table")
    fun getAll(): Flow<List<AsteroidEntity>>

//    @Insert
//    fun insertAll(vararg asteroids: AsteroidEntity)
//    suspend fun insert(word: AsteroidEntity)
}



