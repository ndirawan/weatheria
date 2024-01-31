package com.ndirawan.weatheria.entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CountryCodeDao {
    @Query("SELECT * FROM CountryCode ORDER BY country_name ASC")
    fun getAll() : List<CountryCodeEntity>
    @Query("SELECT * FROM CountryCode WHERE code =:code AND country_name=:cName")
    fun getByCodeAndName(code: String, cName: String) : CountryCodeEntity
    @Query("SELECT * FROM CountryCode WHERE code =:code")
    fun getByCode(code: String) : CountryCodeEntity
    @Insert
    fun insertOne(cc : CountryCodeEntity)
    @Insert
    fun insertAll(countryCode: List<CountryCodeEntity>)
}