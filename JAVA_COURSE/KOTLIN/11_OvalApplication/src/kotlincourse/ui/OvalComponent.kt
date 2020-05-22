package kotlincourse.ui

import javax.swing.*
import java.awt.*

// Наследуемся от стандартного класса, который
// используется для создания компонентов на форме
class OvalComponent(private val r: Int) : JComponent() {
    // Переопределяем метод рисованиая, в который передается
    // объект класса Graphics
    override fun paintComponent(g: Graphics) {
        println("до super  " + g.hashCode() + " hash Объекта " + g.javaClass)
        super.paintComponent(g)
        println("после sup " + g.hashCode() + " hash Объекта " + g.javaClass)

        // Используем Graphics для рисования овала
        // с отступами
        g.drawOval(r, r, width - r * 2, height - r * 2)
    }

}
