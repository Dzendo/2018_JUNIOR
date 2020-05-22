package com.example.day_31_2_list_fragment_k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

//<!-- подключать в activity_main.xml:
// android:name="com.example.day_31_2_list_fragment_k.SingleListFragment_1-4">
//       1 - просто список со cтандартной разметкой без xml и без курсора
//       2 - просто список со  своей разметкой в listfragment.xml с выбором
//       2 - подключили слушатель выбора и сообщение что выбрали
//       4 - настроили вид каждого элемента - добавили значок
//       для этого сделали свою listfragment_row и свой listadapter=myListAdapter
// теоретически можно бы додедлать : кнопки на MAIN и разные вызовы потом
//-->

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 //Разместим фрагмент в разметке основной активности MainActivity. У нас это файл activity_main.xml:
 //  Мы не будем создавать свою разметку и свой адаптер,
 // так как списочный фрагмент уже включает в себя необходимые компоненты.
        Toast.makeText(applicationContext, "Пора вставать! Утро!", Toast.LENGTH_SHORT).show()
    }
}

// Самое распространённое использование фрагментов - списки и связанное с ним содержание.
// При использовании списков на планшете в альбомной ориентации
// справа оставалось слишком много пустого пространства.
// Фрагменты позволяют использовать данное пространство с пользой.
//
//Представим себе ситуацию - у нас есть список ListView, содержащий ссылки.
// При щелчке на одной из ссылок мы открываем вторую активность,
// состоящую из какого-нибудь компонента: TextView или WebView.
// По сути, один экран у нас сменяется другим.
// Можно реализовать эту задачу по другому. На планшетах много места.
// Почему бы не расположить ListView и TextView на одном экране рядышком?
// И когда пользователь будет щёлкать слева на элементе списка,
// то в правой части будет обновляться содержимое TextView.
// Такой подход нам знаком, например, при чтении электронных писем - слева список писем,
// а справа - содержание выбранного письма.
//
//Для связывания данных используются
// адаптеры ListAdapter, ArrayAdapter, SimpleAdapter, SimpleCursorAdapter и т.д.
// Подключение следует производить в методе onActivityCreated().
//
//Стандартная разметка подгружается автоматически,
// для собственной разметки используйте метод onCreateView().

/* View mListContainer; // родительский контейнер (android.R.id.listContainer)
   ListAdapter mAdapter; // адаптер списка
   ListView mList; // список (android.R.id.list)
   TextView mEmptyView; // текстовое поле для пустого списка (android.R.id.empty)
   View mProgressContainer; // компонент для показа анимации загрузки
*/