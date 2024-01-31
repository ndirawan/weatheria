package com.ndirawan.weatheria.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CountryCode")
data class CountryCodeEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "code") val code: String?,
    @ColumnInfo(name = "country_name") val countryName: String?
)
