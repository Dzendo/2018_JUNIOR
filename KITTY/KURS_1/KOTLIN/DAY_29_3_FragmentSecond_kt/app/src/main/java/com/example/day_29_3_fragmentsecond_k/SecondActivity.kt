package com.example.day_29_3_fragmentsecond_k

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) { finish() ; return }

        // Получим индекс из намерения активности
        val intent = intent
        val buttonIndex = intent.getIntExtra("buttonIndex", -1)
        if (buttonIndex < 0)  return

            val fragmentManager = supportFragmentManager
            val fragment2 = fragmentManager
                    .findFragmentById(R.id.fragment2) as Fragment2?
            fragment2?.setDescription(buttonIndex)
    }
}

// Остался один штрих.
// Если в портретной ориентации перейти на вторую активность
// и повернуть устройство в альбомную ориентацию,
// то увидим не тот результат, на который рассчитывали.
// Мы ожидаем увидеть двухпанельный режим, а видим альбомную ориентации второй активности.
// Добавим в метод onCreate() второй активности проверку текущего состояния ориентации.
// Если обнаружим, что находимся в альбомной ориентации, то просто выходим из активности.
// Конечно, можно дополнительно запоминать, какая кнопка была нажата,
// чтобы при возврате на первую активность вывести соответствующие картинки,
// но это уже детали.