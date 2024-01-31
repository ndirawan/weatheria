package com.ndirawan.weatheria.service


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Converter.Factory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpClient {
    fun rerofit(baseUrl : String) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}