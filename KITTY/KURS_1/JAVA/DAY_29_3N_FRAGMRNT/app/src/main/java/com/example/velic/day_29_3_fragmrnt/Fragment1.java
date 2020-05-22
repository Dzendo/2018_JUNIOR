package com.example.velic.day_29_3_fragmrnt;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;




public class Fragment1 extends Fragment implements View.OnClickListener{
    public interface OnSelectedButtonListener {
        void onButtonSelected(int buttonIndex);
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View rootView =
                inflater.inflate(R.layout.fragment1, container, false);
        Button button1 = (Button) rootView.findViewById(R.id.button1);
        Button button2 = (Button) rootView.findViewById(R.id.button2);
        Button button3 = (Button) rootView.findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        int buttonIndex = translateIdToIndex(view.getId());
        Log.d("DAY_29_3_1", "Fragment1 Нажата Кнопка : "+buttonIndex);
        OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
        Log.d("DAY_29_3_2", "Fragment1 Нажата Кнопка : "+buttonIndex);
        listener.onButtonSelected(buttonIndex);
        Log.d("DAY_29_3_3", "Fragment1 Нажата Кнопка : "+buttonIndex);
        // Временный код для получения индекса нажатой кнопки
       Toast.makeText(getActivity(), String.valueOf(buttonIndex),
               Toast.LENGTH_SHORT).show();
        Log.d("DAY_29_3_4", "Fragment1 Нажата Кнопка : "+buttonIndex);
    }


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
