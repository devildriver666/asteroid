package com.udacity.asteroidradar.main

import android.util.Log
import androidx.lifecycle.*
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.Constants
import com.udacity.asteroidradar.api.AsteroidService
import com.udacity.asteroidradar.api.parseAsteroidsJsonResult
import com.udacity.asteroidradar.repository.AsteroidRepository
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainViewModel(private val repository: AsteroidRepository) : ViewModel() {

//    val allAsteroid: LiveData<List<Asteroid>> = repository.allAsteroids.asLiveData()
//
//    fun insert(word: Asteroid) = viewModelScope.launch {
//        repository.insert(word)
//    }

    init {
        loadAsteroid()
    }

    private fun loadAsteroid() {
        try {
            viewModelScope.launch {
                var result = AsteroidService.retrofitService.getAsteroidList("2020-12-11",
                    "2020-12-18" ,
                    "${Constants.API_KEY}")
                val jsonObject = JSONObject(result)
                val asteroidObject =  parseAsteroidsJsonResult(jsonObject)
                println(asteroidObject)
            }
        } catch (e: Exception) {
            Log.i("Respose Fail","$e")
        }
    }

    private fun insertAsteroids(asteroid: Asteroid) {

    }
}

class AsteroidViewModelFactory(private val repository: AsteroidRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}