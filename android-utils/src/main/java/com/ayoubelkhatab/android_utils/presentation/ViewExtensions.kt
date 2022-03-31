package com.ayoubelkhatab.android_utils.presentation

import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

fun View.show() {
    TransitionManager.beginDelayedTransition(rootView as ViewGroup)
    visibility = View.VISIBLE
}

fun View.hide(gone: Boolean = false) {
    TransitionManager.beginDelayedTransition(rootView as ViewGroup)
    visibility = if (gone) View.GONE else View.INVISIBLE
}

fun View.resize(width: Int = this.width, height: Int = this.height) {
    TransitionManager.beginDelayedTransition(rootView as ViewGroup)
    layoutParams = LinearLayout.LayoutParams(width, height)
}