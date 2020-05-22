package com.example.day_30_1_alert_dialog_k

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
// AlertDialog с флажками
class MyDialogFragment6 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val catNamesArray = arrayOf("Васька", "Рыжик", "Мурзик")
        val checkedItemsArray = booleanArrayOf(false, true, false)

        val builder = AlertDialog.Builder(activity!!)
        builder.setTitle("Выберите котов")
                .setMultiChoiceItems(catNamesArray, checkedItemsArray
                ) { dialog, which, isChecked -> checkedItemsArray[which] = isChecked }
                .setPositiveButton("Готово"
                ) { dialog, id ->
                    val state = StringBuilder()
                    for (i in catNamesArray.indices) {
                        state.append(catNamesArray[i])
                        if (checkedItemsArray[i])
                            state.append(" выбран\n")
                        else
                            state.append(" не выбран\n")
                    }
                    Toast.makeText(activity,
                            state.toString(), Toast.LENGTH_LONG)
                            .show()
                }

                .setNegativeButton("Отмена"
                ) { dialog, id -> dialog.cancel() }

        return builder.create()
    }
}
