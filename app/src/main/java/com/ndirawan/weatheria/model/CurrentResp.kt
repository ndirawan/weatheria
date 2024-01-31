package com.ndirawan.weatheria.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.ndirawan.weatheria.model.data.Condition
import com.ndirawan.weatheria.model.data.Current
import com.ndirawan.weatheria.model.data.Location

@Parcelize
data class CurrentResp(

	@field:SerializedName("current")
	val current: Current,

	@field:SerializedName("location")
	val location: Location
) : Parcelable

