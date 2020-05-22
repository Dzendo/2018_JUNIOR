package kotlincourse.component

import javax.swing.*
import java.awt.*

class TriangleComponent : JComponent() {
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        g.drawLine(5, height - 10, width / 2 - 5, 5)
        g.drawLine(width / 2 - 5, 5, width - 10, height - 10)
        g.drawLine(width - 10, height - 10, 5, height - 10)
    }
}