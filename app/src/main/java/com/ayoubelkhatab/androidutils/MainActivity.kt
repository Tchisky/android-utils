package com.ayoubelkhatab.androidutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.ayoubelkhatab.android_utils.presentation.*
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.showAlertDialog).also {
            it.setOnClickListener {
                showAlertDialog(
                    title = "Alert dialog",
                    message = "This is an alert dialog launched from extension library",
                    positiveButtonText = "Accept",
                    positiveIcon = resources.getDrawableById(R.drawable.ic_baseline_thumb_up_24),
                    onPositive = { dialog, _ ->
                        dialog.dismiss()
                    },
                    negativeButtonText = "Cancel",
                    negativeIcon = resources.getDrawableById(R.drawable.ic_baseline_thumb_down_alt_24),
                    onNegative = { dialog, _ ->
                        dialog.dismiss()
                    },
                    cancelable = false,
                    icon = resources.getDrawableById(R.drawable.ic_baseline_warning_24),
                )
            }
        }

        findViewById<MaterialButton>(R.id.showAlertDialogSingleChoice).also {
            it.setOnClickListener {
                lifecycleScope.launch(Dispatchers.Main) {
                    val options = arrayOf("Choice 1", "Choice 2", "Choice 3", "Choice 4")
                    val initialSelect = 0
                    showAlertDialogSingleChoice(
                        title = "Please select a choice",
                        positiveButtonText = "Accept",
                        onPositive = { dialog, _ ->
                            dialog.dismiss()
                        },
                        negativeButtonText = "Cancel",
                        onNegative = { dialog, _ ->
                            dialog.dismiss()
                        },
                        cancelable = false,
                        options = options,
                        initialSelected = initialSelect,
                        onChoiceChanged = { item, index ->
                            showToastShort("Result selected item: $item")
                        },
                    )
                }

            }
        }

        findViewById<MaterialButton>(R.id.showAlertDialogMultiChoice).also {
            it.setOnClickListener {
                val options = arrayOf("Choice 1", "Choice 2", "Choice 3", "Choice 4")
                showAlertDialogMultiChoice(
                    title = "Please select a choice",
                    positiveButtonText = "Accept",
                    onPositive = { dialog, _ ->
                        dialog.dismiss()
                    },
                    negativeButtonText = "Cancel",
                    onNegative = { dialog, _ ->
                        dialog.dismiss()
                    },
                    cancelable = false,
                    options = options,
                    selectedChoices = options.map { true }.toBooleanArray(),
                    onChoiceChanged = { dialog, index, isChecked ->
                        val checked = if (isChecked) "checked" else "unChecked"
                        showToastShort("item: ${options[index]} is $checked")
                    },
                )
            }
        }
    }
}