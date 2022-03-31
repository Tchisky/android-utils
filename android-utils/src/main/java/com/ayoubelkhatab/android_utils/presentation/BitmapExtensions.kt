package com.ayoubelkhatab.android_utils.presentation

import android.graphics.Bitmap
import android.util.Base64
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream

suspend fun Bitmap.encodeToBase64(
    compressFormat: Bitmap.CompressFormat = Bitmap.CompressFormat.JPEG,
    quality: Int = 100
): String = withContext(Dispatchers.IO) {
    val outputStream = ByteArrayOutputStream()
    this@encodeToBase64.compress(compressFormat, quality, outputStream)
    val bytes = outputStream.toByteArray()
    Base64.encodeToString(bytes, Base64.DEFAULT)
}