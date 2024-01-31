package com.ndirawan.weatheria.util

import java.text.SimpleDateFormat
import java.util.*

object ConvertDate {
    fun shorDate(inputDate : String): String{
        val inputFormat = SimpleDateFormat("yyyy-MM-dd H:mm", Locale.US)
        val date = inputFormat.parse(inputDate)
        val outputFormat = SimpleDateFormat("MMM, dd", Locale.US)
        return outputFormat.format(date)
    }
    fun toDay(inputDate : String): String{
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val date = inputFormat.parse(inputDate)
        val outputFormat = SimpleDateFormat("EEEE", Locale.US)
        return outputFormat.format(date)
    }

}