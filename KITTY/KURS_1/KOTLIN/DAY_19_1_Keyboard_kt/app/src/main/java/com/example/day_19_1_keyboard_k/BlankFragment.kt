package com.example.day_19_1_keyboard_k

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText

import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_blank.*


/**
 * Если продолжить тему показа клавиатуры, то может возникнуть следующая ситуация.
 * Допустим у вас есть DialogFragment с EditText.
 * При выводе диалогового окна вам нужно установить фокус на EditText
 * и показать клавиатуру:
 */


class BlankFragment : DialogFragment() {

    // private var editText: EditText? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //val view = inflater.inflate(R.layout.fragment_blank, container)
       // editText = view.findViewById<View>(R.id.txt_yourName) as EditText

        // Request focus and show soft keyboard automatically
        txt_yourName.requestFocus()
        dialog?.window!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        // Когда элемент EditText получает фокус, то появляется клавиатура. Можно установить нужный вид клавиатуры через атрибут InputType или программно через метод setInputType():

        val ipt = txt_yourName //new EditText(this);
        ipt!!.inputType = InputType.TYPE_CLASS_PHONE  //установит клавиатуру для ввода номера телеф

        return view
    }
}//     Empty constructor required for DialogFragment