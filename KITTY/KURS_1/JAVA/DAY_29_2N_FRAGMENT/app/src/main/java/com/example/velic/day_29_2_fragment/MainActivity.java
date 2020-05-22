package com.example.velic.day_29_2_fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

// Заворачиваем в фрагменты
public class MainActivity extends Activity implements Fragment1.OnSelectedButtonListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // mHelloTextView = findViewById(R.id.textView);
       // mNameImageView = findViewById(R.id.imageView);
    }

//  напишем код для пустого метода onButtonSelected(),
// который будет получать от первого фрагмента индекс нажатой кнопки
// и передавать его второму фрагменту:
 // здесь реализация onButtonSelected - метод из Интерфейс из class Fragment1
    @Override
    public void onButtonSelected(int buttonIndex) {
        // подключаем FragmentManager
        FragmentManager fragmentManager = getFragmentManager();

        // Получаем ссылку на второй фрагмент по ID
        Fragment2 fragment2 = (Fragment2) fragmentManager
                .findFragmentById(R.id.fragment2);

        // Выводим нужную информацию
        if (fragment2 != null)
            fragment2.setDescription(buttonIndex);
        // setDescription - метод Fragment2 - заполняет картинкой и текстом поля фрагмента
    }
}
//По цепочке мы передаём информацию от первого фрагмента в активность,
// а затем активность передаёт информацию во второй фрагмент.

// Итак: Нажимаем на кнопку в Fragment1 ->
// срабатывает View.OnClickListener кот implements в Fragment1 и он висит на трех кнопках
// через этот интерфейс вызывает onClick (ovveride в F1)->
// метод onClick в F1 берет ссылку на интерфейс метода F1 OnSelectedButtonListener
// И вызывает его метод onButtonSelected передовая ему номер нажатой кнопки.
// слушателем этого интерфейса является сама MainActivity т.к.
//class MainActivity extends Activity implements Fragment1.OnSelectedButtonListener
// И в MainActivity переопределен (как положено) метод этого интерфейса onButtonSelected
// --> таким образом F1 вызывает onButtonSelected из MainActivity см вверху ->
// -> MainActivity в методе onButtonSelected
// менеджер фрагментов, получает ссылку на второй фрагмент через его идентификатор
// и вызываем его F2 метод setDescription().
// setDescription  в F2 получив номер кнопки выводит у себя нужную картинку
//(своему полю imageView передает картинку)
//На этом вызовы заканчиваются и идет return
// setDescription <- onButtonSelected ( интерфейс OnSelectedButtonListener) <-
// <- onClick F1(xthtp интерфейс View.OnClickListener F1) на картинку в ожидание нажатия

//Если посмотреть на код двух фрагментов,
// то увидим, что они полностью независимы
// и не обращаются ни конкретно к друг другу,
// ни к определённой активности.
// Принцип модульности соблюдён.
// Вы можете добавить любой из этих фрагментов в любую новую активность
// и при этом вам не придётся менять код в самих фрагментах.
// Весь необходимый функционал в фрагментах уже прописан.