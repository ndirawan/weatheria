package com.ndirawan.weatheria.model.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Current(

    @field:SerializedName("feelslike_c")
    val feelslikeC: Double,

    @field:SerializedName("uv")
    val uv: Double,

    @field:SerializedName("last_updated")
    val lastUpdated: String,

    @field:SerializedName("feelslike_f")
    val feelslikeF: Double,

    @field:SerializedName("wind_degree")
    val windDegree: Double,

    @field:SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Double,

    @field:SerializedName("is_day")
    val isDay: Double,

    @field:SerializedName("precip_in")
    val precipIn: Double,

    @field:SerializedName("wind_dir")
    val windDir: String,

    @field:SerializedName("gust_mph")
    val gustMph: Double,

    @field:SerializedName("temp_c")
    val tempC: Double,

    @field:SerializedName("pressure_in")
    val pressureIn: Double,

    @field:SerializedName("gust_kph")
    val gustKph: Double,

    @field:SerializedName("temp_f")
    val tempF: Double,

    @field:SerializedName("precip_mm")
    val precipMm: Double,

    @field:SerializedName("cloud")
    val cloud: Double,

    @field:SerializedName("wind_kph")
    val windKph: Double,

    @field:SerializedName("condition")
    val condition: Condition,

    @field:SerializedName("wind_mph")
    val windMph: Double,

    @field:SerializedName("vis_km")
    val visKm: Double,

    @field:SerializedName("humidity")
    val humidity: Double,

    @field:SerializedName("pressure_mb")
    val pressureMb: Double,

    @field:SerializedName("vis_miles")
    val visMiles: Double
) : Parcelable
