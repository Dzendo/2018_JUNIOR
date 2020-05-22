package com.example.day_30_1_alert_dialog_k

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
  //Диалог с одной кнопкой
class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Важное сообщение!")
                .setMessage("Покормите кота!")
                .setIcon(R.drawable.ic_pets_black_24dp)
                .setPositiveButton("ОК, иду на кухню") { dialog, id ->
                    // Закрываем окно
                    dialog.cancel()
                }
        return builder.create()
    }
}

/* Сначала мы создаём объект класса AlertDialog.Builder,
 передав в качестве параметра ссылку на активность.
 Затем, используя методы класса Builder, задаём для создаваемого диалога заголовок (метод setTitle()),
  текстовое сообщение в теле диалога (метод setMessage()), значок (метод setIcon()),
   а также кнопку через метод под странным названием setPositiveButton().
  */
/*
Сама обработка нажатия кнопки внутри диалогового окна задаётся внутри метода setPositiveButton().
В нашём случае мы просто закрываем окно диалога через метод cancel().

Обратите внимание на не совсем обычный способ вызова череды методов цепочкой через точку
 .setMessage("Покормите кота!").setIcon(R.drawable.ic_android_cat) и т.д.
 Такой синтаксис можно часто увидеть в jQuery.
  При таком способе не нужно использовать точку с запятой в конце каждого метода,
   вы просто склеиваете все вызовы. Но можете использовать и обычный синтаксис.
*/