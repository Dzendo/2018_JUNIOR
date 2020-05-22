package com.example.day_29_6_fragment_detached_k;
//Здесь заведен навигатор с рисунком, ничего не делает

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
//kitty 29_6_2018 Fragment. Не убивание фрагментов
// Фрагментам сказано не умирать с активностью
// следующая активность опятиь присоеденит их к себе
// видимый текст при перерисовке Фрагмента я просто восстанавливаю
// Итого количество насчитаных не забывает приаовороте без запоминания

// Напоминаю, мы не связываем два фрагмента между собой напрямую. Создаём интерфейс для этих целей.


public class MainActivity_java extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
 // Фрагмент передаёт через метод count() данные data,
// а активность их принимает и передаёт их в метод второго фрагмента changeText().
    @Override
    public void count(String data) {
        FragmentManager manager = getSupportFragmentManager();
        WithTextViewFragment withTextViewFragment =
                (WithTextViewFragment) manager.findFragmentById(R.id.fragment_withTextView);
        withTextViewFragment.changeText(data);
    }
}

//Представление фрагмента может уничтожаться и создаваться заново
// без необходимости уничтожать сам фрагмент.
// При изменении конфигурации (повороте) FragmentManager сначала уничтожает макет фрагмента в своем списке.
// Макеты фрагментов всегда уничтожаются и создаются заново по тем же причинам,
// по которым уничтожаются и создаются заново разметки активности:
// в новой конфигурации могут потребоваться новые ресурсы.
// Затем FragmentManager проверяет свойство retainInstance каждого фрагмента.
// Если оно равно false (по умолчанию), FragmentManager уничтожает экземпляр фрагмента.
// Фрагмент и его макет будут созданы заново новым экземпляром FragmentManager новой активности.

// Сохранённые фрагменты продолжают существовать
// только при уничтожении активности при изменения конфигурации.
// Если активность уничтожается из-за того, что системе потребовалось освободить память,
// то все сохранённые фрагменты также будут уничтожены.