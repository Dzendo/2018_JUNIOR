package com.example.day_29_4_fragment_dinamic_k


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*







// Динамическое управление фрагментами
class MainActivity : AppCompatActivity(), Fragment1.OnSelectedButtonListener {
  // Если второго фрагментан не существует (null) или не является частью разметки (isInLayout),
  // то переменная mIsDynamic будет иметь значение true. - т.е. второго фрагмента НЕТ
    private var mIsDynamic: Boolean = false
    internal var fragment1: Fragment1? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        val fragment2 = fragmentManager
                .findFragmentById(R.id.fragment2) as Fragment2?

        // Есть ли втой фрагмент = НЕТ-TRUE  ЕСТЬ - FALSE
        mIsDynamic = fragment2 == null || !fragment2.isInLayout

        Toast.makeText(applicationContext, mIsDynamic.toString() + "", Toast.LENGTH_SHORT).show()

        // Зная, что второго фрагмента нет, загружаем первый сразу на старте
        if (mIsDynamic) {
            // начинаем транзакцию
            val ft = supportFragmentManager.beginTransaction()
            // Создаем и добавляем первый фрагмент в разметку Layout = container

               fragment1 = Fragment1()

            ft.add(R.id.container, fragment1!!, "fragment1")
            // Подтверждаем операцию

            ft.addToBackStack(null)
            ft.setCustomAnimations(
                    android.R.animator.fade_in, android.R.animator.fade_out)
            ft.commit()
        }
    }

    //  напишем код для пустого метода onButtonSelected(),
    // который будет получать от первого фрагмента индекс нажатой кнопки
    // и передавать его второму фрагменту:
    // здесь реализация onButtonSelected - метод из Интерфейс из class Fragment1
    override fun onButtonSelected(buttonIndex: Int) {
        // подключаем FragmentManager
        val fragmentManager = supportFragmentManager
        val fragment2: Fragment2

        // Если фрагмент недоступен
        if (mIsDynamic) {
            // Динамическое переключение на другой фрагмент
            val ft = supportFragmentManager.beginTransaction()
            val fragment2: Fragment2 = Fragment2()

            // Подготавливаем аргументы
            val args = Bundle()
            //args.putInt("button_index", buttonIndex)
            args.putInt(Fragment2.BUTTON_INDEX, buttonIndex)
            fragment2.arguments = args

            ft.replace(R.id.container, fragment2!!, "fragment2")

            ft.addToBackStack(null)

            ft.setCustomAnimations(
                    android.R.animator.fade_in, android.R.animator.fade_out)

           // Toast.makeText(applicationContext, buttonIndex.toString() +"", Toast.LENGTH_SHORT).show()
            ft.commit()  // не вылетает на любом выборе

        } else {  // если второй фрагмент есть
            // Если второй фрагмент доступен
            val fragment2: Fragment2 = fragmentManager
                    .findFragmentById(R.id.fragment2) as Fragment2
            fragment2.setDescription(buttonIndex)
        }
    }
}
//Мы использовали теги fragment в разметке для размещения фрагментов.
// Но существует ещё альтернативный вариант,
// когда фрагмент вставляется в какой-нибудь контейнер динамически.
// В качестве контейнера обычно используют FrameLayout, но можно и другие элементы из ViewGroup.
// Давайте попробуем изменить свою программу под новый способ. 29_4



//  Если фрагмента не существует или он невидим, то запускаем вторую активность. 29_3
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