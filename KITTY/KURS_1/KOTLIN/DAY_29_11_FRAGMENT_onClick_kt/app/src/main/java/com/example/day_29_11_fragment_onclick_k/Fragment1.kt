package com.example.day_29_11_fragment_onclick_k


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment1 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         // val rootView = inflater.inflate(R.layout.fragment1, container, false)
         return inflater.inflate(R.layout.fragment1, container, false)
    }
}
