package com.example.day_29_6_fragment_detached_k

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.fragment.app.Fragment
// сли значение retainInstance равно true, макет фрагмента уничтожается, но сам фрагмент остаётся.
// При создании новой активности новый экземпляр FragmentManager находит сохранённый фрагмент
// и воссоздаёт его макет.

class WithButtonFragment : Fragment(), View.OnClickListener {

    private var mCounter = 0 // счётчик котов
    private var mCommunicator: Communicator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        // Фрагментам сказано не умирать с активностью
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Подключим кнопку в первом фрагменте.
        val rootView = inflater.inflate(R.layout.fragment_with_button, container, false)
        val button = rootView.findViewById<View>(R.id.button) as Button
        button.setOnClickListener(this)
        return rootView
    }

    // Фрагмент с кнопкой может использовать объект интерфейса для отправки данных.
    // Инициализируем его в новом методе onActivityCreated(), который ранее не использовали.
    // Метод сработает, когда активность будет создана и готова к работе.
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mCommunicator = activity as Communicator?
        // видимый текст при перерисовке Фрагмента я просто восстанавливаю:
        if (mCounter > 0) mCommunicator!!.count("Я насчитал $mCounter котов")
    }

    // При щелчках на кнопках мы вызываем метод count(), которому передаём нужную информацию.
    override fun onClick(view: View) {
        mCounter++
        mCommunicator!!.count("Я насчитал $mCounter котов")
    }


}
