package com.ndirawan.weatheria.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ndirawan.weatheria.R
import com.ndirawan.weatheria.databinding.AdapterRcTemperatureBinding
import com.ndirawan.weatheria.model.data.HourItem

class ForecastHourAdapter(
    private val listHour : List<HourItem>,
    private val currentTime: Int
) : RecyclerView.Adapter<ForecastHourAdapter.ViewHolder>() {
    private lateinit var binding: AdapterRcTemperatureBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastHourAdapter.ViewHolder {
        binding = AdapterRcTemperatureBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ForecastHourAdapter.ViewHolder, position: Int) {
        val hourItem = listHour[position]
        val wTime = hourItem.time.substring(hourItem.time.length - 5, hourItem.time.length - 3).toInt()
        holder.rlContainer.background = AppCompatResources.getDrawable(
            holder.itemView.context, when{
                currentTime < wTime ->  R.drawable.card_transparent
                else ->  R.drawable.card_blue
            })
        holder.temperature.text = "${hourItem.tempC}°"
        holder.time.text = hourItem.time.substring(hourItem.time.length - 5, hourItem.time.length)
        Glide.with(holder.itemView)
            .load("https:${hourItem.condition.icon}")
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return listHour.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val temperature = binding.tvTemperature
        val time = binding.tvTime
        val image = binding.image
        val rlContainer = binding.rlContainer
    }
}