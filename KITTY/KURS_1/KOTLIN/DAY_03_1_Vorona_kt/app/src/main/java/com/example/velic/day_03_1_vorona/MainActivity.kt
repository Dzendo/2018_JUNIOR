package com.example.velic.day_03_1_vorona

import android.app.Activity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {
    private var mCountCrows = 0
    private var mCountCats  = 0
    private val KEY_COUNT_Cats  = "COUNT_CATS"
    private val KEY_COUNT_Crows = "COUNT_CROWS"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      // Восстановление счетчиков после поворота:
        if (savedInstanceState ==null ) return
            mCountCats =  savedInstanceState.getInt(KEY_COUNT_Cats, 0)
            mCountCrows = savedInstanceState.getInt(KEY_COUNT_Crows, 1)

       // Вариант с Listener (тогда onClick не нужны) можно так:
      //  button.setOnClickListener { view -> textView.text = " L   Ты кто такой? \n  Давай, до свидания!"}
       // button_Counter_Crows.setOnClickListener{  view -> textView.text = "L Я насчитал " + ++mCountCrows + " ворон" }
       // button_Сounter_Сats.setOnClickListener {  view ->textView.text = "L Я насчитал   ${++mCountCats}  котов" }

    }

    fun onClick(view: View) {textView.text = "F  Ты кто такой? \n  Давай, до свидания!"}
    fun onCrows(view: View) {textView.text = "F Я насчитал " + ++mCountCrows + " ворон"}
    fun onCat  (view: View) {textView.text = "F Я насчитал   ${++mCountCats}  котов"}
// Запоминаем счетчики ворон
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT_Cats,  mCountCats )
        outState.putInt(KEY_COUNT_Crows, mCountCrows)
    }
}
/*
Жизненный цикл при повороте
При повороте активность проходит через цепочку различных состояний. Порядок следующий.

onPause()
onStop()
onDestroy()
onCreate()
onStart()
onResume()
 */

/*
Ориентация у фрагментов
Позже вы узнаете о существовании фрагментов. Может возникнуть такая ситуация,
 когда вы захотите выводить конкретный фрагмент в нужной ориентации.
  У фрагментов есть собственный жизненный цикл,
   и вы можете реализовать свой код в методах фрагмента:

@Override
public void onResume() {
    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
}

@Override
public void onPause() {
	getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    // ваш код
	super.onPause();
}
Я с таким случаем не встречался, но оставлю как памятку.
 */