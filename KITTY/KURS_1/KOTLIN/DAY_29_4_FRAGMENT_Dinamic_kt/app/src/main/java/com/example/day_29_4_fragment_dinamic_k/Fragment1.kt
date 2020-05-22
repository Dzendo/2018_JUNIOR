package com.example.day_29_4_fragment_dinamic_k

//android.app.Fragment, который предназначен для новых устройств

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment1.*
import kotlinx.android.synthetic.main.fragment1.view.*


class Fragment1 : Fragment(), View.OnClickListener {
    // Теперь мы умеем определять индекс нажатой кнопки.
    // Но пока эта информация доступна только самому фрагменту.
    // Наша задача - передать эту информацию активности,
    // которая затем передаст её другой активности.
    //Для этой цели используются интерфейсы.
    interface OnSelectedButtonListener { fun onButtonSelected(buttonIndex: Int) }
    // Интерфейс не определяет работу метода, а только даёт ему имя.
    // Класс, который будет использовать данный интерфейс (MainActivity),
    // должен придумать и переопределить, что делать в методе с данным именем.

    // У нас интерфейс будет использовать класс активности.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        //для подключения разметки используется отдельный метод onCreateView()
        // LayoutInflater, который позволяет построить нужный макет,
        // считывая информацию из указанного XML-файла
        //Остальные два параметра container, false используются в связке
        // и указывают на возможнось подключения фрагментов в активность через контейнер.
        // Мы обойдёмся без контейнеров, а создадим собственные блоки для фрагментов,
        // поэтому у нас используется значение false.

        // return super.onCreateView(inflater, container, savedInstanceState);

        // Для удобства код разбит на две части.
        // Сначала мы получаем объект View, а затем уже его возвращаем в методе.
        val rootView = inflater.inflate(R.layout.fragment1, container, false)

        val button1 = rootView.button1
        val button2 = rootView.button2
        val button3 = rootView.button3
        //  метод findViewById() будет относиться уже не к классу Activity (обычно, мы опускали это),
        // а к корневому элементу разметки фрагмента, в нашем случае rootView.

        // ставим setOnClickListener на три кнопки т.к. он implements
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        // возвращаем фрагменту заполненный контейнер для вывода на экран
        return rootView
    }

    // Добавим обработчик нажатий кнопок (такой же код вы могли использовать в активности, всё знакомо):
    // это переопределенный метод implements View.OnClickListener а он привязан к трем кнопкам
    override fun onClick(view: View) {

         // Фрагмент всегда может узнать, в какой активности он находится, через метод getActivity().
        // так как в фрагментах нет метода getApplicationContext().
        val listener = activity as OnSelectedButtonListener
        listener.onButtonSelected(translateIdToIndex(view.id))

    }

    //  Но у нас три кнопки.
    // Надо написать код, который бы получал информацию о нажатой кнопке,
    // чтобы активность могла использовать эту информацию
    // и использовать её для управления вторым фрагментом.
    // Для удобства создадим отдельный метод,
    // который на основании идентификатора кнопки создаст нужный индекс:
    internal fun translateIdToIndex(id: Int): Int {
       return when (id) {
               R.id.button1 -> 1
               R.id.button2 -> 2
               R.id.button3 -> 3
               else -> -1
           }
    }
}


