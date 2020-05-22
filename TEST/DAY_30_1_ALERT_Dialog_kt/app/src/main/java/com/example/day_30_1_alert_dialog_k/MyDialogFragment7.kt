package com.example.day_30_1_alert_dialog_k

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
// Передать данные в активность
class MyDialogFragment7 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage(" миллион коту?")
                .setIcon(R.drawable.ic_pets_black_24dp)
                .setTitle("Важно! Максимальный перепост")
                .setPositiveButton("OK") { dialog, id -> (activity as MainActivity).okClicked() }
                .setNegativeButton("Отмена") { dialog, id -> (activity as MainActivity).cancelClicked() }

        return builder.create()
    }
}
