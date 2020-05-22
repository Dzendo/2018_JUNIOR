package kotlincourse.component

import java.awt.*

// Класс для рисования треугольника
class TriangleComponent : AbstractShape() {
    override fun paintShape(g: Graphics) {
        g.drawLine(5, height - 10, width / 2 - 5, 5)
        g.drawLine(width / 2 - 5, 5, width - 10, height - 10)
        g.drawLine(width - 10, height - 10, 5, height - 10)
    }
}