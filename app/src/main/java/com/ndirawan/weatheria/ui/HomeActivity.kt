package com.ndirawan.weatheria.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ndirawan.weatheria.adapter.ForecastHourAdapter
import com.ndirawan.weatheria.adapter.NextForecastAdapter
import com.ndirawan.weatheria.databinding.ActivityHomeBinding
import com.ndirawan.weatheria.db.AppDatabase
import com.ndirawan.weatheria.entity.CityEntity
import com.ndirawan.weatheria.model.CurrentResp
import com.ndirawan.weatheria.model.Forecast
import com.ndirawan.weatheria.util.ConvertDate
import com.ndirawan.weatheria.util.CustomAnimation
import java.time.LocalTime

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        val db = AppDatabase.getIntance(this)
        getData(db.CityDao().getAll().firstOrNull()?.cityId ?: 3026315)
        setSearchView(binding.searchView.etSearch, db)
    }

    private fun setSearchView(et : EditText, db: AppDatabase) {
        et.imeOptions = EditorInfo.IME_ACTION_SEARCH
        et.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH){
                viewModel.getCity(et.text.toString())
                inflaterSearch(db)
                hideKeyboard()
                return@setOnEditorActionListener true
            }
            false
        }
    }

    private fun hideKeyboard(){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
    
    @SuppressLint("SetTextI18n")
    private fun getData(id : Int) {
        binding.cardToday.tvDate.visibility = View.VISIBLE
        binding.cardToday.ivDate.visibility = View.GONE
        binding.cardToday.tvCardName.text = "Today"
        viewModel.getWeather(id)
        viewModel.getForecast(id)
        viewModel.getIsFinishedLoad().observe(this){
            if (it){ CustomAnimation.fadeOut(binding.loadingContainer) }
        }
        viewModel.currentWeather.observe(this) { onLoadFinished(it) }
        viewModel.forecastDay.observe(this){ forcecastList(it) }
    }

    private fun inflaterSearch(db: AppDatabase) {
        viewModel.cities.observe(this) {
            val popUpMenu = PopupMenu(this, binding.searchView.etSearch)
            popUpMenu.menu.clear()
            val temp : HashMap<Int, CityEntity> = hashMapOf()
            if (it != null) {
                for ((i, s) in it.withIndex()) {
                    popUpMenu.menu.add(0,i,0,"${s.name} - ${s.region}, ${s.country}")
                    temp[i] = CityEntity(
                        id = i,
                        name = s.name,
                        cityId = s.id,
                        lat = s.lat,
                        long = s.lon,
                        region = s.region,
                        country = s.country
                    )
                }
            }
            popUpMenu.show()
            popUpMenu.setOnMenuItemClickListener { item ->
                checkLocalData(db, temp, item, popUpMenu)
                true
            }
        }
    }

    private fun checkLocalData(db: AppDatabase, temp : HashMap<Int, CityEntity>, item: MenuItem, popUpMenu: PopupMenu)
    : Boolean{
        val info = when (db.CityDao().getAll().isEmpty()) {
            true -> {
                db.CityDao().insertOne(CityEntity())
                db.CityDao().getAll()[0]
            }
            false -> db.CityDao().getAll()[0]
        }
        db.CityDao().updateOne(
            info.copy(
                name = temp[item.itemId]!!.name,
                cityId = temp[item.itemId]!!.cityId,
                lat = temp[item.itemId]!!.lat,
                long = temp[item.itemId]!!.long,
                region = temp[item.itemId]!!.region,
                country = temp[item.itemId]!!.country
            )
        )
        viewModel.getWeather(temp[item.itemId]!!.cityId)
        binding.searchView.etSearch.text.clear()
        binding.searchView.etSearch.focusable = View.NOT_FOCUSABLE
        popUpMenu.dismiss()
        return true
    }
    private fun forcecastList(l : Forecast){
        val t = LocalTime.now().hour
        binding.cardToday.rcList.adapter = ForecastHourAdapter(l.forecastday[0].hour, t)
        binding.cardToday.rcList.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.cardToday.rcList.scrollToPosition(t)
        binding.cardNextForecast.rcList.adapter = NextForecastAdapter(l.forecastday)
        binding.cardNextForecast.rcList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    @SuppressLint("SetTextI18n")
    private fun onLoadFinished(it: CurrentResp?) {
        binding.location.text = "${it?.location?.name}, ${it?.location?.region}"
        binding.temperature.text = "${it?.current?.tempC.toString()}°"
        binding.description.text = it?.current?.condition?.text
        binding.tvWindy.text = "${it?.current?.windKph} km/h"
        binding.tvMist.text = "${it?.current?.humidity}%"
        binding.tvHot.text = "${it?.current?.uv}"
        binding.cardToday.tvDate.text = ConvertDate.shorDate(it?.location?.localtime.toString())
        Glide.with(this).load("https:${it?.current?.condition?.icon}").into(binding.ivIcon)
        binding.feelsLike.text =
            "feels like ${it?.current?.feelslikeC}°"
    }


}