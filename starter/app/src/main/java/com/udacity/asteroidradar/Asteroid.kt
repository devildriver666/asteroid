package com.udacity.asteroidradar

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


data class Asteroid(
    val id: Long,
    val codename: String,
    val closeApproachDate: String,
    val absoluteMagnitude: Double,
    val estimatedDiameter: Double,
    val relativeVelocity: Double,
    val distanceFromEarth: Double,
    val isPotentiallyHazardous: Boolean
                    )


//@Entity (tableName = "asteroid_entity")
//data class AsteroidEntity(
//    @PrimaryKey val id: Int,
//    val codename: String
////    val closeApproachDate: String,
////    val absoluteMagnitude: Double,
////    val estimatedDiameter: Double,
////    val relativeVelocity: Double,
////    val distanceFromEarth: Double,
////    val isPotentiallyHazardous: Boolean
//)

@Entity(tableName = "word_table")
data class AsteroidEntity(@PrimaryKey @ColumnInfo(name = "word") val word: String)