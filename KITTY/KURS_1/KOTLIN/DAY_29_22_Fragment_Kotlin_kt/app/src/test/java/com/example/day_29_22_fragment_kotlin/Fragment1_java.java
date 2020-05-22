package com.example.day_29_22_fragment_kotlin;

//android.app.Fragment, который предназначен для новых устройств
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;


public class Fragment1_java extends Fragment implements View.OnClickListener{
    // Теперь мы умеем определять индекс нажатой кнопки.
    // Но пока эта информация доступна только самому фрагменту.
    // Наша задача - передать эту информацию активности,
    // которая затем передаст её другой активности.
    //Для этой цели используются интерфейсы.
    public interface OnSelectedButtonListener {
        void onButtonSelected(int buttonIndex);
    }
    // Интерфейс не определяет работу метода, а только даёт ему имя.
    // Класс, который будет использовать данный интерфейс (MainActivity),
    // должен придумать и переопределить, что делать в методе с данным именем.

    // У нас интерфейс будет использовать класс активности.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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
        View rootView =
                inflater.inflate(R.layout.fragment1, container, false);
        Button button1 = (Button) rootView.findViewById(R.id.button1);
        Button button2 = (Button) rootView.findViewById(R.id.button2);
        Button button3 = (Button) rootView.findViewById(R.id.button3);
        //  метод findViewById() будет относиться уже не к классу Activity (обычно, мы опускали это),
        // а к корневому элементу разметки фрагмента, в нашем случае rootView.

        // ставим setOnClickListener на три кнопки т.к. он implements
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        // возвращаем фрагменту заполненный контейнер для вывода на экран
        return rootView;
    }
// Добавим обработчик нажатий кнопок (такой же код вы могли использовать в активности, всё знакомо):
// это переопределенный метод implements View.OnClickListener а он привязан к трем кнопкам
    @Override
    public void onClick(View view) {

        int buttonIndex = translateIdToIndex(view.getId());

        // Фрагмент всегда может узнать, в какой активности он находится, через метод getActivity().
       // так как в фрагментах нет метода getApplicationContext().
        OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
        listener.onButtonSelected(buttonIndex);

        // Временный код для получения индекса нажатой кнопки
        Toast.makeText(getActivity(), String.valueOf(buttonIndex),
                Toast.LENGTH_SHORT).show();
    }

//  Но у нас три кнопки.
// Надо написать код, который бы получал информацию о нажатой кнопке,
// чтобы активность могла использовать эту информацию
// и использовать её для управления вторым фрагментом.
// Для удобства создадим отдельный метод,
// который на основании идентификатора кнопки создаст нужный индекс:
    int translateIdToIndex(int id) {
        int index = -1;
        switch (id) {
            case R.id.button1:
                index = 1;
                break;
            case R.id.button2:
                index = 2;
                break;
            case R.id.button3:
                index = 3;
                break;
        }
        return index;
    }
}


