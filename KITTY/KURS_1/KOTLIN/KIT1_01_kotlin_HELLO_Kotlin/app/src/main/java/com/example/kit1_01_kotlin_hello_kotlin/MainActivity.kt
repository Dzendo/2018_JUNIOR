package com.example.kit1_01_kotlin_hello_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*
// этот импорт дает доступ к полям Layout activity_main.xml

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text = "Hello Kotlin"
    }
}
/* Вас ничего не смущает? Где findViewById(), setText() и вот это всё?

Давайте разбираться. В build.gradle(app) есть строчка apply plugin: 'kotlin-android-extensions',
позволяющая автоматически получать доступ к компоненту через его идентификатор в ресурсах.
Смотрите, в разметке у нас есть текстовая метка и кнопка
с идентификаторами android:id="@+id/textView" и android:id="@+id/imageButton".
Готово, теперь вы можете использовать эти имена в коде сразу без объявления: imageButton и textView.
Студия импортирует нужный класс автоматически, когда вы захотите использовать данную возможность,
обратите внимание на строку import kotlinx.android.synthetic.main.activity_main.*.

Теперь переходим к методу setText().
Kotlin позволяет заменить пары методов вида getXX/setXX свойствами без приставок.
Были методы getText()/setText(), остались рожки да ножки свойство text.
Если вы что-то присваиваете свойству, значит вы хотите использовать setText(),
 а если хотите прочитать значение свойства - значит вы хотите вызвать getText().
  Вот так изящно работает Kotlin.
        */
