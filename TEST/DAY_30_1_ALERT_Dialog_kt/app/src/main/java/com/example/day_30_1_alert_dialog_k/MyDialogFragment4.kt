package com.example.day_30_1_alert_dialog_k

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
//  AlertDialog со списком
class MyDialogFragment4 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val catNamesArray = arrayOf("Васька", "Рыжик", "Мурзик")

        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Выберите кота")
                .setItems(catNamesArray) { dialog, which ->
                    Toast.makeText(activity,
                            "Выбранный кот: " + catNamesArray[which],
                            Toast.LENGTH_SHORT).show()
                }

        return builder.create()
    }
}
