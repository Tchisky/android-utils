package com.ayoubelkhatab.android_utils.presentation

import android.content.Context
import android.content.DialogInterface
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ayoubelkhatab.android_utils.domain.ScreenSize
import com.google.android.material.snackbar.Snackbar

fun AppCompatActivity.showToastShort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.showToastLong(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun AppCompatActivity.showToast(message: String, duration: Int? = null) {
    Toast.makeText(this, message, duration ?: Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.hideSoftKeyboard() {
    val imm =
        getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = this.currentFocus
    if (view == null) {
        view = View(this)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun AppCompatActivity.showSoftKeyboard(view: View) {
    if (view.requestFocus()) {
        val imm =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }
}

fun AppCompatActivity.screenSize(): ScreenSize {
    val displayMetrics = Resources.getSystem().displayMetrics
    val widthPx = displayMetrics.heightPixels.toFloat()
    val widthDp = widthPx.toDp(this)

    val heightPx = displayMetrics.heightPixels.toFloat()
    val heightDp = heightPx.toDp(this)

    return ScreenSize(
        widthDp = widthDp,
        widthPx = widthPx,
        heightPx = heightPx,
        heightDp = heightDp,
        density = displayMetrics.density,
        densityDpi = displayMetrics.densityDpi,
        scaleDensity = displayMetrics.scaledDensity
    )
}


fun AppCompatActivity.showSnackBar(
    rootView: View,
    message: String,
    duration: Int,
    actionLabel: String? = null,
    @StringRes actionLabelRes: Int? = null,
    onAction: (View) -> Unit = {}
) {
    Snackbar.make(rootView, message, duration).apply {
        actionLabelRes?.let { resText ->
            setAction(resText, onAction)
        }
        actionLabel?.let { text ->
            setAction(text, onAction)
        }
        show()
    }
}

fun AppCompatActivity.showSnackBarLong(
    rootView: View,
    message: String,
    actionLabel: String? = null,
    @StringRes actionLabelRes: Int? = null,
    onAction: (View) -> Unit = {}
) {
    Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).apply {
        actionLabelRes?.let { resText ->
            setAction(resText, onAction)
        }
        actionLabel?.let { text ->
            setAction(text, onAction)
        }
        show()
    }
}

fun AppCompatActivity.showSnackBarShort(
    rootView: View,
    message: String,
    actionLabel: String? = null,
    @StringRes actionLabelRes: Int? = null,
    onAction: (View) -> Unit = {}
) {
    Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).apply {
        actionLabelRes?.let { resText ->
            setAction(resText, onAction)
        }
        actionLabel?.let { text ->
            setAction(text, onAction)
        }
        show()
    }
}

fun AppCompatActivity.showSnackBarIndefinite(
    rootView: View,
    message: String,
    actionLabel: String? = null,
    @StringRes actionLabelRes: Int? = null,
    onAction: (View) -> Unit = {}
) {
    Snackbar.make(rootView, message, Snackbar.LENGTH_INDEFINITE).apply {
        actionLabelRes?.let { resText ->
            setAction(resText, onAction)
        }
        actionLabel?.let { text ->
            setAction(text, onAction)
        }
        show()
    }
}

fun AppCompatActivity.showAlertDialog(
    @StringRes titleRes: Int? = null,
    title: String? = null,
    @StringRes messageRes: Int? = null,
    cancelable: Boolean = true,
    message: String? = null,
    @DrawableRes iconRes: Int? = null,
    icon: Drawable? = null,
    @StringRes positiveButtonTextRes: Int? = null,
    positiveButtonText: String? = null,
    positiveIcon: Drawable? = null,
    onPositive: DialogInterface.OnClickListener = DialogInterface.OnClickListener { _, _ -> },
    @StringRes negativeButtonTextRes: Int? = null,
    negativeButtonText: String? = null,
    negativeIcon: Drawable? = null,
    onNegative: DialogInterface.OnClickListener = DialogInterface.OnClickListener { _, _ -> },
    @StringRes neutralButtonTextRes: Int? = null,
    neutralButtonText: String? = null,
    neutralIcon: Drawable? = null,
    onNeutral: DialogInterface.OnClickListener = DialogInterface.OnClickListener { _, _ -> },
    onCancel: DialogInterface.OnCancelListener = DialogInterface.OnCancelListener { },
    onDismiss: DialogInterface.OnDismissListener = DialogInterface.OnDismissListener { },
): AlertDialog {
    val dialog = AlertDialog.Builder(this).apply {
        setCancelable(cancelable)
        titleRes?.let {
            setTitle(it)
        } ?: setTitle(title)

        messageRes?.let {
            setMessage(it)
        } ?: setMessage(message)

        positiveButtonTextRes?.let {
            setPositiveButton(it, onPositive)
        } ?: setPositiveButton(positiveButtonText, onPositive)

        negativeButtonTextRes?.let {
            setNegativeButton(it, onNegative)
        } ?: setNegativeButton(negativeButtonText, onNegative)

        neutralButtonTextRes?.let {
            setNeutralButton(it, onNeutral)
        } ?: setNeutralButton(neutralButtonText, onNeutral)

        iconRes?.let {
            setIcon(it)
        } ?: setIcon(icon)

        positiveIcon?.let {
            setPositiveButtonIcon(it)
        }

        negativeIcon?.let {
            setNegativeButtonIcon(it)
        }

        neutralIcon?.let {
            setNeutralButtonIcon(it)
        }
        setOnCancelListener(onCancel)
        setOnDismissListener(onDismiss)
    }
    return dialog.show()
}

fun AppCompatActivity.showAlertDialogSingleChoice(
    @StringRes titleRes: Int? = null,
    title: String? = null,
    options: Array<String>,
    initialSelected: Int,
    onChoiceChanged: (String, Int) -> Unit,
    cancelable: Boolean = true,
    @DrawableRes iconRes: Int? = null,
    icon: Drawable? = null,
    @StringRes positiveButtonTextRes: Int? = null,
    positiveButtonText: String? = null,
    positiveIcon: Drawable? = null,
    onPositive: DialogInterface.OnClickListener = DialogInterface.OnClickListener { _, _ -> },
    @StringRes negativeButtonTextRes: Int? = null,
    negativeButtonText: String? = null,
    negativeIcon: Drawable? = null,
    onNegative: DialogInterface.OnClickListener = DialogInterface.OnClickListener { _, _ -> },
    @StringRes neutralButtonTextRes: Int? = null,
    neutralButtonText: String? = null,
    neutralIcon: Drawable? = null,
    onNeutral: DialogInterface.OnClickListener = DialogInterface.OnClickListener { _, _ -> },
    onCancel: DialogInterface.OnCancelListener = DialogInterface.OnCancelListener { },
    onDismiss: DialogInterface.OnDismissListener = DialogInterface.OnDismissListener { },
): Unit {
    AlertDialog.Builder(this@showAlertDialogSingleChoice).apply {
        setCancelable(cancelable)
        titleRes?.let {
            setTitle(it)
        } ?: setTitle(title)

        positiveButtonTextRes?.let {
            setPositiveButton(it, onPositive)
        } ?: setPositiveButton(positiveButtonText, onPositive)

        negativeButtonTextRes?.let {
            setNegativeButton(it, onNegative)
        } ?: setNegativeButton(negativeButtonText, onNegative)

        neutralButtonTextRes?.let {
            setNeutralButton(it, onNeutral)
        } ?: setNeutralButton(neutralButtonText, onNeutral)

        iconRes?.let {
            setIcon(it)
        } ?: setIcon(icon)

        positiveIcon?.let {
            setPositiveButtonIcon(it)
        }

        negativeIcon?.let {
            setNegativeButtonIcon(it)
        }

        neutralIcon?.let {
            setNeutralButtonIcon(it)
        }

        setSingleChoiceItems(
            options,
            initialSelected,
        ) { _, index ->
            onChoiceChanged(options[index], index)
        }

        setOnCancelListener(onCancel)
        setOnDismissListener(onDismiss)
        show()
    }
}

fun AppCompatActivity.showAlertDialogMultiChoice(
    @StringRes titleRes: Int? = null,
    title: String? = null,
    options: Array<String>,
    selectedChoices: BooleanArray = options.map { false }.toBooleanArray(),
    onChoiceChanged: DialogInterface.OnMultiChoiceClickListener,
    cancelable: Boolean = true,
    @DrawableRes iconRes: Int? = null,
    icon: Drawable? = null,
    @StringRes positiveButtonTextRes: Int? = null,
    positiveButtonText: String? = null,
    positiveIcon: Drawable? = null,
    onPositive: DialogInterface.OnClickListener = DialogInterface.OnClickListener { _, _ -> },
    @StringRes negativeButtonTextRes: Int? = null,
    negativeButtonText: String? = null,
    negativeIcon: Drawable? = null,
    onNegative: DialogInterface.OnClickListener = DialogInterface.OnClickListener { _, _ -> },
    @StringRes neutralButtonTextRes: Int? = null,
    neutralButtonText: String? = null,
    neutralIcon: Drawable? = null,
    onNeutral: DialogInterface.OnClickListener = DialogInterface.OnClickListener { _, _ -> },
    onCancel: DialogInterface.OnCancelListener = DialogInterface.OnCancelListener { },
    onDismiss: DialogInterface.OnDismissListener = DialogInterface.OnDismissListener { },
) {
    AlertDialog.Builder(this).apply {
        setCancelable(cancelable)
        titleRes?.let {
            setTitle(it)
        } ?: setTitle(title)

        positiveButtonTextRes?.let {
            setPositiveButton(it, onPositive)
        } ?: setPositiveButton(positiveButtonText, onPositive)

        negativeButtonTextRes?.let {
            setNegativeButton(it, onNegative)
        } ?: setNegativeButton(negativeButtonText, onNegative)

        neutralButtonTextRes?.let {
            setNeutralButton(it, onNeutral)
        } ?: setNeutralButton(neutralButtonText, onNeutral)

        iconRes?.let {
            setIcon(it)
        } ?: setIcon(icon)

        positiveIcon?.let {
            setPositiveButtonIcon(it)
        }

        negativeIcon?.let {
            setNegativeButtonIcon(it)
        }

        neutralIcon?.let {
            setNeutralButtonIcon(it)
        }

        setMultiChoiceItems(
            options,
            selectedChoices,
            onChoiceChanged
        )

        setOnCancelListener(onCancel)
        setOnDismissListener(onDismiss)
        show()
    }
}