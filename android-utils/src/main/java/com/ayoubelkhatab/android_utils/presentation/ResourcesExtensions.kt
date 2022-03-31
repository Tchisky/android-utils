package com.ayoubelkhatab.android_utils.presentation

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap

fun Resources.getDrawableById(@DrawableRes id: Int): Drawable? {
    return ResourcesCompat.getDrawable(
        this,
        id,
        Resources.getSystem().newTheme()
    )
}

fun Resources.getDrawableByIdAsBitmap(@DrawableRes id: Int): Bitmap? {
    return ResourcesCompat.getDrawable(
        this,
        id,
        Resources.getSystem().newTheme()
    )?.toBitmap()
}