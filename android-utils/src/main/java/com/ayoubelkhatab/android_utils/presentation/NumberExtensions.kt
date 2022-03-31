package com.ayoubelkhatab.android_utils.presentation

import android.content.Context
import android.util.DisplayMetrics
import kotlin.math.roundToInt

/**
 * Integer
 */
fun Int.toPx(context: Context): Int {
    // consider this int as dp
    val displayMetrics: DisplayMetrics = context.resources.displayMetrics
    return (this * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()

}

fun Int.toDp(context: Context): Float {
    // consider this int as px
    val displayMetrics: DisplayMetrics = context.resources.displayMetrics
    return this / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)
}

/**
 * Floats
 */
fun Float.toPx(context: Context): Int {
    // consider this int as dp
    val displayMetrics: DisplayMetrics = context.resources.displayMetrics
    return (this * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
}

fun Float.toDp(context: Context): Float {
    // consider this int as px
    val displayMetrics: DisplayMetrics = context.resources.displayMetrics
    return this / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)
}

/**
 * Doubles
 */
fun Double.toPx(context: Context): Int {
    // consider this int as dp
    val displayMetrics: DisplayMetrics = context.resources.displayMetrics
    return (this * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
}

fun Double.toDp(context: Context): Float {
    // consider this int as px
    val displayMetrics: DisplayMetrics = context.resources.displayMetrics
    return this.toFloat() / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)
}