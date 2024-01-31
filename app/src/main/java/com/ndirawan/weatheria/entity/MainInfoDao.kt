package com.ndirawan.weatheria.entity

import androidx.room.*

@Dao
interface MainInfoDao {
    @Query("SELECT * FROM MainInfoEntity LIMIT 1")
    fun getInfo(): MainInfoEntity
    @Update
    fun updateInfo(mainInfoEntity: MainInfoEntity)
    @Insert
    fun insertInfo(mainInfoEntity: MainInfoEntity)
    @Delete
    fun deleteMainInfo(mainInfoEntity: MainInfoEntity)
}