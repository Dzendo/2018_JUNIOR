package com.example.day_29_5_fragment_communicator_k

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_with_text_view.*
// При сахарозе вылетает


class WithTextViewFragment : Fragment() {
    private var mTextView: TextView? = null
    private var mData: String? = null
 // mData, которая будет хранить текст сообщения.для поворота экрана

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Во втором фрагменте подключим компонент TextView и добавим метод для вывода текста.
        val rootView = inflater.inflate(R.layout.fragment_with_text_view, container, false)
        mTextView = rootView.findViewById<View>(R.id.textView) as TextView
        if (savedInstanceState == null) {

        } else {
            mData = savedInstanceState.getString("text")
            mTextView!!.text = mData
        }
        return rootView
    }
// Мы знаем, что при поворотах активность создаётся заново.
// Поэтому все данные сбрасываются. Чтобы сохранить данные,
// у фрагментов есть соответствующие методы, схожие с подобными методами у активностей.
// Задействуем их.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("text", mData)
    //Параметр метода outState является объектом класса Bundle
    // и позволяет хранить различные типы в формате "ключ-значение".
    }

    fun changeText(data: String) {
        mData = data
        mTextView!!.text = mData
    }
}

// При повороте фрагмент сохранит значение счётчика, перезапустится и восстановит значение счётчика.
// Если запустить пример, то увидим следующее. Щёлкнем несколько раз по кнопке и повернём экран.
// Данные сбросятся и мы снова увидим пустой текст.
// Но стоит нам нажать на кнопку, то увидим, что отсчёт пошёл не сначала,
// а продолжил со своего последнего значения.
// Мы видим, что первый фрагмент запоминает свои данные.
// А второй фрагмент пока тупит. Поможем ему.

// Добавим новую переменную mData, которая будет хранить текст сообщения. У метода onCreateView() также есть параметр savedInstanceState класса Bundle, позволяющий извлечь сохранённые данные.
//
//А текст мы сохраним в методе onSaveInstanceState().
// В методе changeText() добавим строку кода, чтобы текст брался из новой переменной.
// Теперь при первом запуске всё работает как прежде.
// При повороте текст из mData сохраняется в методе putString() и восстанавливается через getString().
