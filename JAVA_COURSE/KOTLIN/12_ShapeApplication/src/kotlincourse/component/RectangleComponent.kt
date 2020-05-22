package kotlincourse.component

import javax.swing.*
import java.awt.*

class RectangleComponent : JComponent() {
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        g.drawRect(5, 5, width - 10, height - 10)
    }
}