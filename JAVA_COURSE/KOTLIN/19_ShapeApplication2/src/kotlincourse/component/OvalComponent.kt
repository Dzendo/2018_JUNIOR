package kotlincourse.component

import java.awt.*

// Класс для рисования овала
class OvalComponent : AbstractShape() {
    override fun paintShape(g: Graphics) {
        g.drawOval(5, 5, width - 10, height - 10)
    }
}
