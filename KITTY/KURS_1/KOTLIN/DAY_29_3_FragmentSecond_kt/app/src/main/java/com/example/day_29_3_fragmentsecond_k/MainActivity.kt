package com.example.day_29_3_fragmentsecond_k


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

// Заворачиваем в фрагменты
class MainActivity : AppCompatActivity(), Fragment1.OnSelectedButtonListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //  напишем код для пустого метода onButtonSelected(),
    // который будет получать от первого фрагмента индекс нажатой кнопки
    // и передавать его второму фрагменту:
    // здесь реализация onButtonSelected - метод из Интерфейс из class Fragment1
    override fun onButtonSelected(buttonIndex: Int) {
        // подключаем FragmentManager
        val fragmentManager = supportFragmentManager
       // Получаем ссылку на второй фрагмент по ID

        val fragment2 = fragmentManager
                .findFragmentById(R.id.fragment2) as Fragment2?
        if (fragment2 == null || !fragment2.isVisible) {
           // запускаем активность в портрете
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("buttonIndex", buttonIndex)
            startActivity(intent)
            // стартовали вторую активность, передали ей номер картинки, - >
            // она сама вызовет setDescription для вывода картинки
        } else {
            // Выводим нужную информацию в ORIENTATION_LANDSCAPE
            fragment2?.setDescription(buttonIndex)
            // setDescription - метод Fragment2 - заполняет картинкой и текстом поля фрагмента
        }
    }
}
//  Если фрагмента не существует или он невидим, то запускаем вторую активность.
// В противном случае фрагмент присутствует в активности, и тогда работаем по старому сценарию.

//По цепочке мы передаём информацию от первого фрагмента в активность,
// а затем активность передаёт информацию во второй фрагмент.

// Итак: Нажимаем на кнопку в Fragment1 ->
// срабатывает View.OnClickListener кот implements в Fragment1 и он висит на трех кнопках
// через этот интерфейс вызывает onClick (ovveride в F1)->
// метод onClick в F1 берет ссылку на интерфейс метода F1 OnSelectedButtonListener
// И вызывает его метод onButtonSelected передовая ему номер нажатой кнопки.
// слушателем этого интерфейса является сама MainActivity т.к.
//class MainActivity extends Activity implements Fragment1.OnSelectedButtonListener
// И в MainActivity переопределен (как положено) Activity.getFragmentManager()метод этого интерфейса onButtonSelected
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