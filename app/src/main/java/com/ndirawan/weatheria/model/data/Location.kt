package com.ndirawan.weatheria.model.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(

    @field:SerializedName("localtime")
    val localtime: String,

    @field:SerializedName("country")
    val country: String,

    @field:SerializedName("localtime_epoch")
    val localtimeEpoch: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("lon")
    val lon: Double,

    @field:SerializedName("region")
    val region: String,

    @field:SerializedName("lat")
    val lat: Double,

    @field:SerializedName("tz_id")
    val tzId: String
) : Parcelable
