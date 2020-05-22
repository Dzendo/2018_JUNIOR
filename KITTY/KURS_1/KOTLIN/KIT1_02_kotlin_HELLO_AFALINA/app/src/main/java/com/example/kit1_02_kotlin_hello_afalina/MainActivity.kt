package com.example.kit1_02_kotlin_hello_afalina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
// этот импорт обеспечивает доступ к полям Layout activity_main.xml


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageButton.setOnClickListener { view -> textView.text = "Привет Afalina D" }
    }
    fun onClick (view: View) = if (editText.text.isEmpty())
        textView.text = "Hello Delfina A!"
    else
        textView.text = "Привет,\n  ${editText.text}"
}
/*
 В build.gradle(app) есть строчки и много
  apply plugin: 'kotlin-android'
  apply plugin: 'kotlin-android-extensions', Вторая позволяющая
  автоматически получать доступ к компоненту через его идентификатор в ресурсах.

В разметке у нас есть текстовая метка и кнопка
android:id="@+id/textView" и android:id="@+id/imageButton".
Теперь можно использовать эти имена в коде сразу без объявления: imageButton и textView.
Студия импортирует нужный класс автоматически,
обратите внимание на строку import kotlinx.android.synthetic.main.activity_main.*.

Теперь переходим к методу getText()/setText().
Kotlin позволяет заменить пары методов вида getXX/setXX свойствами без приставок.
Были методы getText()/setText(), осталось свойство text.
Если что-то присваиваем свойству, значит хотим использовать setText(): textView.text =
 а если хотим прочитать значение свойства - значит вызваем getText(): =editText.text
 */
