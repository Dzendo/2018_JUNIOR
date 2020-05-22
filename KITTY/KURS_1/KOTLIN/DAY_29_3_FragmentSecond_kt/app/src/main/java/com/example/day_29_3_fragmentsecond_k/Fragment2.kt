package com.example.day_29_3_fragmentsecond_k

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment2.*
import com.example.day_29_3_fragmentsecond_k.R.drawable.*
import com.example.day_29_3_fragmentsecond_k.R.array.*



class Fragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {return inflater.inflate(R.layout.fragment2, container, false)}

    //Подготовим метод (вызывается из Main),
    // который будет менять содержимое фрагмента
    // в зависимости от индекса нажатой кнопки:
    fun setDescription(buttonIndex: Int) {
        // в стоку подключается текст из массива из ресурсов с номером buttonIndex
        textView.text = resources.getStringArray(cats)[buttonIndex]

         when (buttonIndex) {
            1 -> imageView.setImageResource(chicken)
            2 -> imageView.setImageResource(dog)
            3 -> imageView.setImageResource(duck)
            else -> imageView.setImageResource(cat_yellow)
        }
    }
}