package com.example.day_29_6_fragment_detached_k;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class WithTextViewFragment_java extends Fragment {
    private TextView mTextView;
    private String mData;
//У фрагмента есть свойство retainInstance, которое по умолчанию содержит значение false.
// Это означает, что при поворотах фрагмент не сохраняется,
// а уничтожается и создается заново вместе с активностью-хостом.
// Вызов setRetainInstance(true) сохраняет фрагмент, который не уничтожается вместе с активностью,
// а передается новой активности в неизменном виде.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        // Фрагментам сказано не умирать с активностью
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment_with_text_view, container, false);
        mTextView = (TextView) rootView.findViewById(R.id.textView);

        return rootView;
    }


    public void changeText(String data) {
        mData = data;
        mTextView.setText(mData);
    }
}

// Сохранённый фрагмент не уничтожается, а отсоединяется (detached) от «умирающей» активности.
// В сохранённом состоянии фрагмент всё ещё существует, но не имеет активности-хоста.

// Переход в сохранённое состояние происходит только при выполнении двух условий:
//
//для фрагмента был вызван метод setRetainInstance(true)
//активность-хост уничтожается для изменения конфигурации (обычно поворот).
// Фрагмент находится в сохранённом состоянии очень недолго
// — от момента отсоединения от старой активности до повторного присоединения к новой,
// немедленно создаваемой активности.