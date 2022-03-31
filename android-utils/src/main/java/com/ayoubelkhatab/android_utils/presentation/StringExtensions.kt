package com.ayoubelkhatab.android_utils.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

/**
 * accepts only either dd-mm-yyyy or mm-dd-yyy
 * delimiter between day and month and year can be anything
 */
@RequiresApi(Build.VERSION_CODES.O)
fun String.toLocalDate(
    date: String,
    delimiter: Char,
    dayMonthYear: Boolean = true
): LocalDate? {
    if (date.contains(delimiter)) {
        val dateList = date.split(delimiter)
        return if (dayMonthYear) {
            LocalDate.of(
                dateList[2].toInt(),
                dateList[1].toInt(),
                dateList.first().toInt(),
            )
        } else {
            LocalDate.of(
                dateList[2].toInt(),
                dateList.first().toInt(),
                dateList[1].toInt(),
            )
        }
    }
    return null
}