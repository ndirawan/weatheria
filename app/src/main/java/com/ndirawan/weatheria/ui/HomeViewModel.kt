package com.ndirawan.weatheria.ui

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ndirawan.weatheria.model.CurrentResp
import com.ndirawan.weatheria.model.Forecast
import com.ndirawan.weatheria.model.ForecastResp
import com.ndirawan.weatheria.model.data.RegionResp
import com.ndirawan.weatheria.service.ApiService
import com.ndirawan.weatheria.service.BaseURL
import com.ndirawan.weatheria.service.HttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val apiWeather = HttpClient().rerofit(BaseURL.WEATHER).create(ApiService::class.java)
    val currentWeather = MutableLiveData<CurrentResp?>()
    val forecastDay = MutableLiveData<Forecast>()
    val cities = MutableLiveData<List<RegionResp>>()
    val loadCurrent = MutableLiveData<Boolean>()
    val loadForecast = MutableLiveData<Boolean>()
    private val isFinished = MediatorLiveData<Boolean>()
    fun getWeather(q: Int, lang: String = "en") {
        apiWeather.getCurrentWeather(q = "id:$q", lang = lang)
            .enqueue(object : Callback<CurrentResp>{
                override fun onResponse(p0: Call<CurrentResp>, p1: Response<CurrentResp>) {
                    currentWeather.value = p1.body()
                    loadCurrent.value = true
                }

                override fun onFailure(p0: Call<CurrentResp>, p1: Throwable) {
                    loadCurrent.value = false
                }
            })
    }

    fun getForecast(q : Int){
        apiWeather.getForecast(q = "id:$q")
            .enqueue(object : Callback<ForecastResp>{
                override fun onResponse(p0: Call<ForecastResp>, p1: Response<ForecastResp>) {
                    forecastDay.value = p1.body()?.forecast
                    loadForecast.value = true
                }
                override fun onFailure(p0: Call<ForecastResp>, p1: Throwable) {
                    loadForecast.value = false
                }
            })

    }

    fun getCity(q: String){
        apiWeather.getCity(q)
            .enqueue(object : Callback<List<RegionResp>> {
                override fun onResponse(p0: Call<List<RegionResp>>, p1: Response<List<RegionResp>>) {
                    cities.value = p1.body()
                }

                override fun onFailure(p0: Call<List<RegionResp>>, p1: Throwable) {
                }
            })
    }
    fun getIsFinishedLoad() : MutableLiveData<Boolean> {
        isFinished.addSource(loadCurrent) { isFinished.value = loadCurrent.value == true && loadForecast.value == true }
        isFinished.addSource(loadForecast) { isFinished.value = loadCurrent.value == true && loadForecast.value == true }
        return isFinished
    }
}