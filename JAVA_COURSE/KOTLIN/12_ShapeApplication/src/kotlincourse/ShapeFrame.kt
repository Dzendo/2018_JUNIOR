package kotlincourse

import kotlincourse.component.OvalComponent
import kotlincourse.component.RectangleComponent
import kotlincourse.component.TriangleComponent

import javax.swing.*
import java.awt.*

class ShapeFrame : JFrame() {
    init {
        // Устанавливаем LayoutManager в виде таблицы
        // размерами 2 строки на 3 столбца
        layout = GridLayout(3, 3)

        // Создаем и "укладываем" на форму компоненты разных классов
        add(RectangleComponent())
        add(OvalComponent())
        add(TriangleComponent())
        add(OvalComponent())
        add(RectangleComponent())
        add(TriangleComponent())
        add(OvalComponent())
        add(RectangleComponent())
        add(TriangleComponent())


        // Устанавливаем координаты и размеры окна
        setBounds(200, 200, 450, 350)
    }
}
