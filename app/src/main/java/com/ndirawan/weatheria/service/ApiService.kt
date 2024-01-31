package com.ndirawan.weatheria.service


import com.ndirawan.weatheria.BuildConfig
import com.ndirawan.weatheria.model.*
import com.ndirawan.weatheria.model.data.RegionResp
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("current.json")
    fun getCurrentWeather(
        @Query("q") q : String,
        @Query("lang") lang : String,
        @Query("key") key : String = BuildConfig.APIKEY
    ): Call<CurrentResp>

    @GET("forecast.json")
    fun getForecast(
        @Query("q") q : String,
        @Query("days") days : Int = 7,
        @Query("key") appId : String = BuildConfig.APIKEY
    ): Call<ForecastResp>
    @GET("search.json")
    fun getCity(
        @Query("q") q : String,
        @Query("key") appId : String = BuildConfig.APIKEY
    ): Call<List<RegionResp>>

}