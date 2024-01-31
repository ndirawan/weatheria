package com.ndirawan.weatheria.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CityEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "Name") val name: String = "Jakarta",
    @ColumnInfo(name = "CityID") val cityId: Int = 3026315,
    @ColumnInfo(name = "Lat") val lat: Double = -6.21,
    @ColumnInfo(name = "Long") val long: Double = 106.85,
    @ColumnInfo(name = "Region") val region : String = "Jakarta Raya",
    @ColumnInfo(name = "Country") val country: String = "Indonesia"
)
