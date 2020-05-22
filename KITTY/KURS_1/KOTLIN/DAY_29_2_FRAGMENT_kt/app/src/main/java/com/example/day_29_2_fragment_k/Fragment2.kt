package com.example.day_29_2_fragment_k

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment2.*
import com.example.day_29_2_fragment_k.R.drawable.*
import com.example.day_29_2_fragment_k.R.string.*




class Fragment2 : Fragment() {
    private var mInfoTextView: TextView? = null
    private var mCatImageView: ImageView? = null
    private var mCatDescriptionArray: Array<String>? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // return super.onCreateView(inflater, container, savedInstanceState);
        val rootView = inflater.inflate(R.layout.fragment2, container, false)
        mInfoTextView = rootView.findViewById<View>(R.id.textView) as TextView
        mCatImageView = rootView.findViewById<View>(R.id.imageView) as ImageView

        // загружаем массив из ресурсов
        mCatDescriptionArray = resources.getStringArray(R.array.cats)
        return rootView
    }

    //Подготовим метод (вызывается из Main),
    // который будет менять содержимое фрагмента
    // в зависимости от индекса нажатой кнопки:
    fun setDescription(buttonIndex: Int) {
        // в стоку подключается текст из массива из ресурсов с номером buttonIndex
        val catDescription = mCatDescriptionArray!![buttonIndex]
        mInfoTextView!!.text = catDescription

        when (buttonIndex) {
            1 -> mCatImageView!!.setImageResource(R.drawable.chicken)
            2 -> mCatImageView!!.setImageResource(R.drawable.dog)
            3 -> mCatImageView!!.setImageResource(R.drawable.duck)

            else -> {
            }
        }
    }
}