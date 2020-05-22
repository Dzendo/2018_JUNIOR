package com.example.day_29_4_fragment_dinamic_k

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.fragment2.*
import com.example.day_29_4_fragment_dinamic_k.R.drawable.*
import com.example.day_29_4_fragment_dinamic_k.R.array.*



class Fragment2 : Fragment() {
    private var mInfoTextView: TextView? = null
    private var mCatImageView: ImageView? = null
    private var mCatDescriptionArray: Array<String>? = null
    // Имя для аргумента
    companion object {   /* блок статических переменных - констант */
        @JvmStatic public  val BUTTON_INDEX = "button_index"
        // Значение по умолчанию
        @JvmStatic private val BUTTON_INDEX_DEFAULT = -1
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        val rootView = inflater.inflate(R.layout.fragment2, container, false)

        mInfoTextView = rootView.findViewById(R.id.textView)  as TextView
        mCatImageView = rootView.findViewById(R.id.imageView) as ImageView


        // загружаем массив из ресурсов
        mCatDescriptionArray = resources.getStringArray(cats)

        // Получим индекс, если имеется
        val args = arguments
        val buttonIndex = args?.getInt(BUTTON_INDEX,
                BUTTON_INDEX_DEFAULT) ?: BUTTON_INDEX_DEFAULT
        Toast.makeText(activity, "buttonIndex" +buttonIndex.toString() +"buttonIndex", Toast.LENGTH_SHORT).show()
        // Если индекс обнаружен, то используем его

        if (buttonIndex != BUTTON_INDEX_DEFAULT)
            setDescription(buttonIndex)

        return rootView
    }

    //Подготовим метод (вызывается из Main),
    // который будет менять содержимое фрагмента
    // в зависимости от индекса нажатой кнопки:

    fun setDescription(buttonIndex: Int) {

        // в стоку подключается текст из массива из ресурсов с номером buttonIndex
        /////////////// НЕ РАБОТАЕТ ВЫЛЕТАЕТ /////////////// в 29_4 а в 29_3 работает
       /* textView.text = resources.getStringArray(cats)[buttonIndex]
                when (buttonIndex) {
            1 -> imageView.setImageResource(chicken)
            2 -> imageView.setImageResource(dog)
            3 -> imageView.setImageResource(duck)
            else -> imageView.setImageResource(cat_yellow)
        }*/
       // val catDescription = mCatDescriptionArray!![buttonIndex]
        //mInfoTextView!!.setText(catDescription)
        mInfoTextView!!.setText(resources.getStringArray(cats)[buttonIndex])

        when (buttonIndex) {
            1 -> mCatImageView!!.setImageResource(chicken)
            2 -> mCatImageView!!.setImageResource(dog)
            3 -> mCatImageView!!.setImageResource(duck)

            else -> mCatImageView!!.setImageResource(cat_yellow)

        }

    }
}