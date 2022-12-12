package com.monika.petapp.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object TimeUtil {
    // convert milliseconds to hours:minutes float format
    fun currentTimeInHHmm(milliseconds: Long): Float {
        @SuppressLint("SimpleDateFormat") val minutes =
            SimpleDateFormat("mm").format(Date(milliseconds)).toInt()
        @SuppressLint("SimpleDateFormat") val hours =
            SimpleDateFormat("HH").format(Date(milliseconds)).toInt()
        return "$hours.$minutes".toFloat()
    }

    // convert string time to float
    fun currentToFloat(time: String): Float {
        val currentTime = time.split(":").toTypedArray()
        return (currentTime[0] + "." + currentTime[1]).toFloat()
    }

    // convert milliseconds into the day of the week string
    fun dayStringFormat(msecs: Long): Int {
        val cal = GregorianCalendar()
        cal.time = Date(msecs)
        when (cal[Calendar.DAY_OF_WEEK]) {
            Calendar.MONDAY -> return 0
            Calendar.TUESDAY -> return 1
            Calendar.WEDNESDAY -> return 2
            Calendar.THURSDAY -> return 3
            Calendar.FRIDAY -> return 4
            Calendar.SATURDAY -> return 5
            Calendar.SUNDAY -> return 6
        }
        return -1
    }
}