package com.example.day_19_1_keyboard_k;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;


/**
 Если продолжить тему показа клавиатуры, то может возникнуть следующая ситуация.
 Допустим у вас есть DialogFragment с EditText.
 При выводе диалогового окна вам нужно установить фокус на EditText
 и показать клавиатуру:
 */



public class BlankFragment_java extends DialogFragment {

    private EditText editText;

    public BlankFragment_java() {
    //     Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container);
        editText = (EditText) view.findViewById(R.id.   txt_yourName);

        // Request focus and show soft keyboard automatically
        editText.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
       // Когда элемент EditText получает фокус, то появляется клавиатура. Можно установить нужный вид клавиатуры через атрибут InputType или программно через метод setInputType():

        EditText ipt = editText; //new EditText(this);
        ipt.setInputType(InputType.TYPE_CLASS_PHONE);  //установит клавиатуру для ввода номера телеф

        return view;
    }
}