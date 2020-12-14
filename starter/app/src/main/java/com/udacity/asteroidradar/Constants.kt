package com.udacity.asteroidradar

object Constants {
    const val API_QUERY_DATE_FORMAT = "yyyy-MM-dd"
    const val DEFAULT_END_DATE_DAYS = 7
    const val BASE_URL = "https://api.nasa.gov/"
    const val API_KEY = "IJbXCDcjKVqhS4Pv2DZjyYewkPvEKXE4nwgGyzac"
}

object QueryConstants {

    const val ASTEROID_QUERY = "neo/rest/v1/feed?"
    const val IMAGE_OF_DAY = "planetary/apod?api_key="
}

//https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=IJbXCDcjKVqhS4Pv2DZjyYewkPvEKXE4nwgGyzac