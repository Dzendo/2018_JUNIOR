package com.example.day_29_6_fragment_detached_k;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class WithButtonFragment_java extends Fragment implements View.OnClickListener{

    private int mCounter = 0; // счётчик котов
    private Communicator mCommunicator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        // Фрагментам сказано не умирать с активностью
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Подключим кнопку в первом фрагменте.
        View rootView =
                inflater.inflate(R.layout.fragment_with_button, container, false);
        Button button = (Button)rootView.findViewById(R.id.button);
        button.setOnClickListener(this);
        return rootView;
    }
// Фрагмент с кнопкой может использовать объект интерфейса для отправки данных.
// Инициализируем его в новом методе onActivityCreated(), который ранее не использовали.
// Метод сработает, когда активность будет создана и готова к работе.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCommunicator = (Communicator)getActivity();
        // видимый текст при перерисовке Фрагмента я просто восстанавливаю:
       if (mCounter>0) mCommunicator.count("Я насчитал " + mCounter + " котов");
    }
    // При щелчках на кнопках мы вызываем метод count(), которому передаём нужную информацию.
    @Override
    public void onClick(View view) {
        mCounter++;
        mCommunicator.count("Я насчитал " + mCounter + " котов");
    }


}
