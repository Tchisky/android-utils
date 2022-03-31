package com.ayoubelkhatab.android_utils.presentation

import android.util.Base64
import android.util.Base64OutputStream
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield
import java.io.*

suspend fun File.saveToStorage(fileName: String = this.name, storageDir: File): String? =
    withContext(Dispatchers.IO) {
        yield()

        if (!storageDir.exists())
            storageDir.mkdirs()

        val file = File(storageDir, fileName)
        val bytes = readBytes()

        try {
            val outputStream = FileOutputStream(file.path)
            outputStream.write(bytes)
            outputStream.close()
            file.path
        } catch (ex: IOException) {
            null
        }
    }

suspend fun File.encodeToBase64(): String = withContext(Dispatchers.IO) {
    FileInputStream(this@encodeToBase64).use { inputStream ->
        ByteArrayOutputStream().use { outputStream ->
            Base64OutputStream(outputStream, Base64.DEFAULT).use { base64FilterStream ->
                inputStream.copyTo(base64FilterStream)
                base64FilterStream.close()
                outputStream.toString()
            }
        }
    }
}