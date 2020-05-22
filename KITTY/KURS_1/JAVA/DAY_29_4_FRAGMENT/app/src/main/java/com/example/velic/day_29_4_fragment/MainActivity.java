package com.example.velic.day_29_4_fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;

import android.widget.Toast;
//Kitty, урок 29 часть 4, "Динамическое управление фрагментами"
//в портретной ориентации фрагмент 1 с кнопками вызова фрагмента 2
//по нажатию на кнопку в фрагменте 1 динамически заменяем фрагмент 1 на фрагмент2.
//Возврат к фаргменту1 предусмотрен клавишей назад
//В альбомной ориентации у на оба фрагмента сразу грузятся в туже самую майн активити и
//там друг с другом работают, ничего не заменяя, не подменяя, как в 29_2
//При повороте экрана туда обратно методом хитрых проверок перестраивается майн активити
//Это пример как одной активити организовать диалог заменой фрагментов.
//И в портретной и альбомной ориентации работает быстрее и лучше, чем вызов второй активности
//Дима как-то доломал, есть ошибка:
//вызвав ципленка в портрете, после поворота в альбом вышла в рабочий стол?
//ЛВ повторить такой эффект не удалось
//Нужно стек стирать, что бы выйти из программы, все предыдущие вызовы

public class MainActivity extends Activity implements Fragment1.OnSelectedButtonListener{
   private boolean mIsDynamic;
    Fragment1 fragment1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        Fragment2 fragment2 = (Fragment2) fragmentManager
                .findFragmentById(R.id.fragment2);
         mIsDynamic = fragment2 == null || !fragment2.isInLayout();
        Toast.makeText(getApplicationContext(), mIsDynamic + "", Toast.LENGTH_SHORT).show();
        // Зная, что второго фрагмента нет, загружаем первый
        if (mIsDynamic) {
            // Динамическое переключение на другой фрагмент
            FragmentTransaction ft = fragmentManager.beginTransaction();
            fragment1 = new Fragment1();
            ft.replace(R.id.container, fragment1, "fragment1");
            ft.addToBackStack(null);
            ft.setCustomAnimations(
                    android.R.animator.fade_in, android.R.animator.fade_out);
            ft.commit();
        }
    }

   @Override
    public void onButtonSelected(int buttonIndex) {
       // подключаем FragmentManager
       FragmentManager fragmentManager = getFragmentManager();
       Fragment2 fragment2;

       // Если фрагмент недоступен
       if (mIsDynamic) {
           // Динамическое переключение на другой фрагмент
           FragmentTransaction ft = fragmentManager.beginTransaction();
           fragment2 = new Fragment2();

           // Подготавливаем аргументы
           Bundle args = new Bundle();
           args.putInt(Fragment2.BUTTON_INDEX, buttonIndex);
           fragment2.setArguments(args);

           ft.replace(R.id.container, fragment2, "fragment2");
           ft.addToBackStack(null);
           ft.setCustomAnimations(
                   android.R.animator.fade_in, android.R.animator.fade_out);
           ft.commit();
       } else {
           // Если фрагмент доступен
           fragment2 = (Fragment2) fragmentManager
                   .findFragmentById(R.id.fragment2);
           fragment2.setDescription(buttonIndex);
       }
   }
}

