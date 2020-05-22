package com.example.day_29_5_fragment_communicator_k

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.fragment.app.Fragment


class WithButtonFragment : Fragment(), View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private var mCounter = 0 // счётчик котов
    private var mCommunicator: Communicator? = null

    //   private OnFragmentInteractionListener mListener;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Подключим кнопку в первом фрагменте.
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_with_button, container, false);
        val rootView = inflater.inflate(R.layout.fragment_with_button, container, false)
        val button = rootView.findViewById<View>(R.id.button) as Button
        button.setOnClickListener(this)
        return rootView
    }
// Фрагмент с кнопкой может использовать объект интерфейса для отправки данных.
// Инициализируем его в новом методе onActivityCreated(), который ранее не использовали.
// Метод сработает, когда активность будет создана и готова к работе.
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mCommunicator = activity as Communicator?
    }
// При щелчках на кнопках мы вызываем метод count(), которому передаём нужную информацию.
    override fun onClick(view: View) {
        mCounter++
        mCommunicator!!.count("Я насчитал $mCounter котов")
    }
// Мы знаем, что при поворотах активность создаётся заново.
// Поэтому все данные сбрасываются. Чтобы сохранить данные,
// у фрагментов есть соответствующие методы, схожие с подобными методами у активностей.
// Задействуем их.


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", mCounter)
    }
// У фрагментов также есть метод onCreate(Bundle savedInstanceState),
// где используется объект этого же класса Bundle только под другим именем savedInstanceState.
// Несмотря на разные имена, речь идёт об одном и том же объекте.
// И сохраняя данные в методе onSaveInstanceState(), мы можем их получить в методе onCreate():
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            mCounter = 0
        } else {
            mCounter = savedInstanceState.getInt("counter", 0)
        }
    }
}
