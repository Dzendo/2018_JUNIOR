package com.example.day_29_2_fragment_k;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;


public class Fragment2_java extends Fragment {
    private TextView mInfoTextView;
    private ImageView mCatImageView;
    private String[] mCatDescriptionArray;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View rootView =
                inflater.inflate(R.layout.fragment2, container, false);
        mInfoTextView = (TextView) rootView.findViewById(R.id.textView);
        mCatImageView = (ImageView) rootView.findViewById(R.id.imageView);

        // загружаем массив из ресурсов
        mCatDescriptionArray = getResources().getStringArray(R.array.cats);
        return rootView;
    }
    //Подготовим метод (вызывается из Main),
    // который будет менять содержимое фрагмента
    // в зависимости от индекса нажатой кнопки:
    public void setDescription(int buttonIndex) {
        // в стоку подключается текст из массива из ресурсов с номером buttonIndex
        String catDescription = mCatDescriptionArray[buttonIndex];
        mInfoTextView.setText(catDescription);

        switch (buttonIndex) {
            case 1:
                mCatImageView.setImageResource(R.drawable.chicken);
                break;
            case 2:
                mCatImageView.setImageResource(R.drawable.dog);
                break;
            case 3:
                mCatImageView.setImageResource(R.drawable.duck);
                break;

            default:
                break;
        }
    }
}