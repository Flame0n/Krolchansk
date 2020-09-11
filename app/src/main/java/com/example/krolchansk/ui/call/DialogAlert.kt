package com.example.krolchansk.ui.call

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.os.Message
import androidx.fragment.app.DialogFragment

class DialogAlert(val title: String, val message: String): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("Ок") {
                        dialog, id ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}