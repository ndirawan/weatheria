package com.ndirawan.weatheria.model.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Condition(

    @field:SerializedName("code")
    val code: Int,

    @field:SerializedName("icon")
    val icon: String,

    @field:SerializedName("text")
    val text: String
) : Parcelable
