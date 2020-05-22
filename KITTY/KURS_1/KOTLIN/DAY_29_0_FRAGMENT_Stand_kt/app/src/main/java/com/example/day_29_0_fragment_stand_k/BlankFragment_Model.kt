package com.example.day_29_0_fragment_stand_k

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class BlankFragment_Model : Fragment() {

    companion object {
        fun newInstance() = BlankFragment_Model()
    }

    private lateinit var viewModel: BlankFragmentModelViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.blank_fragment__model_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BlankFragmentModelViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
