package kotlincourse

// Мы ИМПОРТИРОВАЛИ класс из пакета

import javax.swing.*

object SimpleFrame {
    private var jButton2: javax.swing.JButton? = null

    @JvmStatic
    fun main(args: Array<String>) {
        jButton2 = javax.swing.JButton()
        // Создали экземпляр класса - объект
        val sf = JFrame()

        jButton2!!.text = "<html><p align=center>OK</p>Выход из программы"
        // Установим заголовок
        sf.title = "Мое Окно"
        // Установим свойсво - завершить приложение при закрытии окна
        sf.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        // Выставим координаты и размеры
        // Верхний левый угол - первые два числа 100 и 100
        // Ширина и высота - вторы два числа 400 и 200
        sf.setBounds(200, 200, 600, 400)
        // Отобразим окно, сделав его видимым
        //String SSS="AAAA";
        //sf.add(SSS);
        sf.isVisible = true
        val sf1 = JFrame()
        // Установим заголовок
        sf1.title = "Мое Окно1"
        // Установим свойсво - завершить приложение при закрытии окна
        sf1.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        // Выставим координаты и размеры
        // Верхний левый угол - первые два числа 100 и 100
        // Ширина и высота - вторы два числа 400 и 200
        sf1.setBounds(600, 600, 800, 400)
        sf.add(jButton2)

        // Отобразим окно, сделав его видимым
        //String SSS="AAAA";
        //sf.add(SSS);
        sf.isVisible = true
        sf1.isVisible = true
        // Теперь у нас на экране появилось окно, которым
        // можно управлять - перетаскивать, менять размеры.
        // Разве не красиво ?
    }
}
