package com.example.day_29_5_fragment_communicator_k;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class WithTextViewFragment_java extends Fragment {
    private TextView mTextView;
    private String mData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment_with_text_view, container, false);
        mTextView = (TextView) rootView.findViewById(R.id.textView);
        if(savedInstanceState == null){

        }else {
            mData = savedInstanceState.getString("text");
            mTextView.setText(mData);
        }
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", mData);
    }

    public void changeText(String data) {
        mData = data;
        mTextView.setText(mData);
    }
}
