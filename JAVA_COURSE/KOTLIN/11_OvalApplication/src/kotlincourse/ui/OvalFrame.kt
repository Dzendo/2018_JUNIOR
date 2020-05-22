package kotlincourse.ui

import javax.swing.*

class OvalFrame(s: String) : JFrame(s) {
    init {
        val oc = OvalComponent(50)
        // Испольщзуем метод класса JFrame для добавления
        // компонента на главную панель.
        add(oc)
        val oc1 = OvalComponent(5)
        add(oc1)
        // Устанавливаем координаты и размеры окна
        setBounds(200, 200, 300, 250)
    }// Создаем объект типа OvalComponent

}
