package com.ndirawan.weatheria.model.data

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class RegionResp(

	@field:SerializedName("country")
	val country: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("lon")
	val lon: Double,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("region")
	val region: String,

	@field:SerializedName("lat")
	val lat: Double,

	@field:SerializedName("url")
	val url: String
) : Parcelable
