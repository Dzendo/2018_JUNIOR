package com.example.velic.day_29_6_fragment_navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class WithTextViewFragment extends Fragment {
    private TextView mTextView;
    private String mData;
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
