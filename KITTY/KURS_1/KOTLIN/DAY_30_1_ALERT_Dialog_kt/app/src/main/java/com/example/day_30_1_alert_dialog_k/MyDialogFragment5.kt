package com.example.day_30_1_alert_dialog_k

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast

import androidx.fragment.app.DialogFragment
// AlertDialog с переключателями
class MyDialogFragment5 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val catNamesArray = arrayOf("Васька", "Рыжик", "Мурзик")

        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Выберите любимое имя кота")
                // добавляем переключатели
                .setSingleChoiceItems(catNamesArray, -1
                ) { dialog, item ->
                    Toast.makeText(
                            activity,
                            "Любимое имя кота: " + catNamesArray[item],
                            Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("OK") { dialog, id ->
                    // User clicked OK, so save the mSelectedItems results somewhere
                    // or return them to the component that opened the dialog
                }
                .setNegativeButton("Отмена") { dialog, id -> }

        return builder.create()
    }
}
