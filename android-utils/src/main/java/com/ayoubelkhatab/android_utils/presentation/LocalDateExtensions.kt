package com.ayoubelkhatab.android_utils.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * formats a date into string using the provided [pattern]
 */
@RequiresApi(Build.VERSION_CODES.O)
fun LocalDate.formatToString(pattern: String, locale: Locale = Locale.getDefault()): String {
    val formatter = DateTimeFormatter.ofPattern(pattern, locale)
    return this.format(formatter)
}