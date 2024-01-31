package com.ndirawan.weatheria.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ndirawan.weatheria.databinding.AdapterRcNextForecastBinding
import com.ndirawan.weatheria.model.ForecastdayItem
import com.ndirawan.weatheria.util.ConvertDate

class NextForecastAdapter (private val list :List<ForecastdayItem>)
    : RecyclerView.Adapter<NextForecastAdapter.ViewHolder>() {
    private lateinit var binding: AdapterRcNextForecastBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextForecastAdapter.ViewHolder {
        binding = AdapterRcNextForecastBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: NextForecastAdapter.ViewHolder, poisition: Int) {
        val f = list[poisition]
        holder.tvDay.text = ConvertDate.toDay(f.date)
        holder.tvMinMaxTemp.text = "${f.day.mintempC}° / ${f.day.maxtempC}°"
        Glide.with(holder.itemView)
            .load("https:${f.day.condition.icon}")
            .into(holder.ivIcon)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tvDay = binding.tvDate
        val tvMinMaxTemp = binding.tvMinMaxTemp
        val ivIcon = binding.ivIcon
    }
}