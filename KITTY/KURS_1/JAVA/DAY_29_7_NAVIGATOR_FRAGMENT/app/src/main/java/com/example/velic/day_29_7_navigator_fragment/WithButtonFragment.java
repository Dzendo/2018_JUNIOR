package com.example.velic.day_29_7_navigator_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class WithButtonFragment extends Fragment {
     //   implements View.OnClickListener{


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

        View rootView =
                inflater.inflate(R.layout.fragment_with_button, container, false);
        Button button = (Button)rootView.findViewById(R.id.button);
        //button.setOnClickListener(this);
        return rootView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCommunicator = (Communicator)getActivity();
        // видимый текст при перерисовке Фрагмента я просто восстанавливаю:
       if (mCounter>0) mCommunicator.count("Я насчитал " + mCounter + " котов");
    }
/*
    @Override
    public void onClick(View view) {
        mCounter++;
        mCommunicator.count("Я насчитал " + mCounter + " котов");
    } */
public void onClickButton(View view) {
    Toast.makeText(getActivity(), "WithButtonFragment",
            Toast.LENGTH_SHORT).show();

}

}
