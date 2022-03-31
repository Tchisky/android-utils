package com.ayoubelkhatab.android_utils.domain

import android.util.Log

fun Any?.isNull() = this == null

fun Any?.isNotNull() = this != null

fun Any.logVerbose(message: String, throwable: Throwable? = null) {
    val tag = this.javaClass.simpleName
    Log.v(tag, message, throwable)
}

fun Any.logInfo(message: String, throwable: Throwable? = null) {
    val tag = this.javaClass.simpleName
    Log.i(tag, message, throwable)
}

fun Any.logDebug(message: String, throwable: Throwable? = null) {
    val tag = this.javaClass.simpleName
    Log.d(tag, message, throwable)
}

fun Any.logWarning(message: String, throwable: Throwable? = null) {
    val tag = this.javaClass.simpleName
    Log.w(tag, message, throwable)
}

fun Any.logError(message: String, throwable: Throwable? = null) {
    val tag = this.javaClass.simpleName
    Log.e(tag, message, throwable)
}