package kotlincourse.component

import java.awt.*

// Класс для рисования прямоугольника
class RectangleComponent : AbstractShape() {
    override fun paintShape(g: Graphics) {
        g.drawRect(5, 5, width - 10, height - 10)
    }
}