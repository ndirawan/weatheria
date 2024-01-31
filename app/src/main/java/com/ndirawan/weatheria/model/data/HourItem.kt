package com.ndirawan.weatheria.model.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HourItem(

    @field:SerializedName("feelslike_c")
    val feelslikeC: Double,

    @field:SerializedName("feelslike_f")
    val feelslikeF: Double,

    @field:SerializedName("wind_degree")
    val windDegree: Double,

    @field:SerializedName("windchill_f")
    val windchillF: Double,

    @field:SerializedName("windchill_c")
    val windchillC: Double,

    @field:SerializedName("temp_c")
    val tempC: Double,

    @field:SerializedName("temp_f")
    val tempF: Double,

    @field:SerializedName("cloud")
    val cloud: Double,

    @field:SerializedName("wind_kph")
    val windKph: Double,

    @field:SerializedName("wind_mph")
    val windMph: Double,

    @field:SerializedName("snow_cm")
    val snowCm: Double,

    @field:SerializedName("humidity")
    val humidity: Double,

    @field:SerializedName("dewpoDouble_f")
    val dewpoDoubleF: Double,

    @field:SerializedName("will_it_rain")
    val willItRain: Double,

    @field:SerializedName("uv")
    val uv: Double,

    @field:SerializedName("heatindex_f")
    val heatindexF: Double,

    @field:SerializedName("dewpoDouble_c")
    val dewpoDoubleC: Double,

    @field:SerializedName("diff_rad")
    val diffRad: Double,

    @field:SerializedName("is_day")
    val isDay: Double,

    @field:SerializedName("precip_in")
    val precipIn: Double,

    @field:SerializedName("heatindex_c")
    val heatindexC: Double,

    @field:SerializedName("wind_dir")
    val windDir: String,

    @field:SerializedName("gust_mph")
    val gustMph: Double,

    @field:SerializedName("pressure_in")
    val pressureIn: Double,

    @field:SerializedName("chance_of_rain")
    val chanceOfRain: Double,

    @field:SerializedName("gust_kph")
    val gustKph: Double,

    @field:SerializedName("precip_mm")
    val precipMm: Double,

    @field:SerializedName("short_rad")
    val shortRad: Double,

    @field:SerializedName("condition")
    val condition: Condition,

    @field:SerializedName("will_it_snow")
    val willItSnow: Double,

    @field:SerializedName("vis_km")
    val visKm: Double,

    @field:SerializedName("time_epoch")
    val timeEpoch: Double,

    @field:SerializedName("time")
    val time: String,

    @field:SerializedName("chance_of_snow")
    val chanceOfSnow: Double,

    @field:SerializedName("pressure_mb")
    val pressureMb: Double,

    @field:SerializedName("vis_miles")
    val visMiles: Double
) : Parcelable
