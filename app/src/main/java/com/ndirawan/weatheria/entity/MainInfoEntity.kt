package com.ndirawan.weatheria.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MainInfoEntity")
data class MainInfoEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int = 0,
    @ColumnInfo("name") val name: String = "User",
    @ColumnInfo("language") val language: String = "EN",
    @ColumnInfo("units") val units: String = "metric"
)
