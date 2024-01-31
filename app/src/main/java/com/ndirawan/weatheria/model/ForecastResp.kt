package com.ndirawan.weatheria.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.ndirawan.weatheria.model.data.Condition
import com.ndirawan.weatheria.model.data.Current
import com.ndirawan.weatheria.model.data.HourItem
import com.ndirawan.weatheria.model.data.Location

@Parcelize
data class ForecastResp(

	@field:SerializedName("current")
	val current: Current,

	@field:SerializedName("location")
	val location: Location,

	@field:SerializedName("forecast")
	val forecast: Forecast
) : Parcelable

@Parcelize
data class Day(

	@field:SerializedName("avgvis_km")
	val avgvisKm: Double,

	@field:SerializedName("uv")
	val uv: Double,

	@field:SerializedName("avgtemp_f")
	val avgtempF: Double,

	@field:SerializedName("avgtemp_c")
	val avgtempC: Double,

	@field:SerializedName("daily_chance_of_snow")
	val dailyChanceOfSnow: Double,

	@field:SerializedName("maxtemp_c")
	val maxtempC: Double,

	@field:SerializedName("maxtemp_f")
	val maxtempF: Double,
	@field:SerializedName("mintemp_c")
	val mintempC: Double,

	@field:SerializedName("mintemp_f")
	val mintempF: Double,

	@field:SerializedName("mDoubleemp_c")
	val mDoubleempC: Double,

	@field:SerializedName("avgvis_miles")
	val avgvisMiles: Double,

	@field:SerializedName("daily_will_it_rain")
	val dailyWillItRain: Double,

	@field:SerializedName("mDoubleemp_f")
	val mDoubleempF: Double,

	@field:SerializedName("totalprecip_in")
	val totalprecipIn: Double,

	@field:SerializedName("totalsnow_cm")
	val totalsnowCm: Double,

	@field:SerializedName("avghumidity")
	val avghumidity: Double,

	@field:SerializedName("condition")
	val condition: Condition,

	@field:SerializedName("maxwind_kph")
	val maxwindKph: Double,

	@field:SerializedName("maxwind_mph")
	val maxwindMph: Double,

	@field:SerializedName("daily_chance_of_rain")
	val dailyChanceOfRain: Double,

	@field:SerializedName("totalprecip_mm")
	val totalprecipMm: Double,

	@field:SerializedName("daily_will_it_snow")
	val dailyWillItSnow: Double
) : Parcelable

@Parcelize
data class Astro(

	@field:SerializedName("moonset")
	val moonset: String,

	@field:SerializedName("moon_illumination")
	val moonIllumination: Double,

	@field:SerializedName("sunrise")
	val sunrise: String,

	@field:SerializedName("moon_phase")
	val moonPhase: String,

	@field:SerializedName("sunset")
	val sunset: String,

	@field:SerializedName("is_moon_up")
	val isMoonUp: Double,

	@field:SerializedName("is_sun_up")
	val isSunUp: Double,

	@field:SerializedName("moonrise")
	val moonrise: String
) : Parcelable

@Parcelize
data class ForecastdayItem(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("astro")
	val astro: Astro,

	@field:SerializedName("date_epoch")
	val dateEpoch: Double,

	@field:SerializedName("hour")
	val hour: List<HourItem>,

	@field:SerializedName("day")
	val day: Day
) : Parcelable

@Parcelize
data class Forecast(

	@field:SerializedName("forecastday")
	val forecastday: List<ForecastdayItem>
) : Parcelable
