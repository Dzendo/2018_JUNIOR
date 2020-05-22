package com.example.day_30_1_alert_dialog_k

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
// Три кнопки
class MyDialogFragment3 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Выберите правильный ответ")
                .setCancelable(true)
                .setPositiveButton("Мяу"
                ) { dialog, id ->
                    //dialog.cancel();
                    Toast.makeText(activity, "Вы нажали на кнопку мяу",
                            Toast.LENGTH_LONG).show()
                }
                .setNeutralButton("Гав"
                ) { dialog, id ->
                    //dialog.cancel();
                    Toast.makeText(activity, "Вы нажали на кнопку гав",
                            Toast.LENGTH_LONG).show()
                }
                .setNegativeButton("Сам дурак!"
                ) { dialog, id ->
                    //dialog.cancel();
                    Toast.makeText(activity, "Вы нажали на кнопку дурак",
                            Toast.LENGTH_LONG).show()
                }

        return builder.create()
    }
}
