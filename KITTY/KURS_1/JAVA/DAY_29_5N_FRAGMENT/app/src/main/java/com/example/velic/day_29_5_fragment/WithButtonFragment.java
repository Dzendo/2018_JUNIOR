package com.example.velic.day_29_5_fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class WithButtonFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private int mCounter = 0; // счётчик котов
    private Communicator mCommunicator;

 //   private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_with_button, container, false);
        View rootView =
                inflater.inflate(R.layout.fragment_with_button, container, false);
        Button button = (Button)rootView.findViewById(R.id.button);
        button.setOnClickListener(this);
        return rootView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCommunicator = (Communicator)getActivity();
    }

    @Override
    public void onClick(View view) {
        mCounter++;
        mCommunicator.count("Я насчитал " + mCounter + " котов");
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", mCounter);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            mCounter = 0;
        } else {
            mCounter = savedInstanceState.getInt("counter", 0);
        }
    }
}
