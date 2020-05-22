package com.example.day_30_1_alert_dialog_k

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
// пример создания диалогового окна с двумя кнопками на основе иллюстрации
class MyDialogFragment2 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = "Выбор есть всегда"
        val message = "Выбери пищу"
        val button1String = "Вкусная"
        val button2String = "Здоровая"

        val builder = AlertDialog.Builder(activity)
        builder.setTitle(title)  // заголовок
        builder.setMessage(message) // сообщение
        builder.setPositiveButton(button1String) { dialog, id ->
            Toast.makeText(activity, "Вы сделали правильный выбор",
                    Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton(button2String) { dialog, id ->
            Toast.makeText(activity, "Возможно вы правы", Toast.LENGTH_LONG)
                    .show()
        }
        builder.setCancelable(true)

        return builder.create()
    }
}
