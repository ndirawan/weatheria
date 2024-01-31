package com.ndirawan.weatheria.entity

import androidx.room.*

@Dao
interface CityDao {
    @Query("SELECT * FROM CityEntity ORDER BY Name ASC")
    fun getAll(): List<CityEntity>
    @Insert
    fun insertOne(cityEntity: CityEntity)
    @Update
    fun updateOne(cityEntity: CityEntity)
    @Delete
    fun delete(cityEntity: CityEntity)
}