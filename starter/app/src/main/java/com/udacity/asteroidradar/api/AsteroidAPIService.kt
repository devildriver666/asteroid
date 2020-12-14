package com.udacity.asteroidradar.api

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.Constants
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

//private var moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()



//val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
////logging.level = (HttpLoggingInterceptor.Level.BASIC)
val client = OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).build()



private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(Constants.BASE_URL).client(client)
    .build()

interface AsteroidAPIService {
    @GET("neo/rest/v1/feed")
    suspend fun getAsteroidList(@Query("start_date") start_date:String,
                        @Query("start_date") end_date:String,
                        @Query("api_key") api_key:String): String
}

object AsteroidService {
    val retrofitService : AsteroidAPIService by lazy {
        retrofit.create(AsteroidAPIService::class.java)
    }
}