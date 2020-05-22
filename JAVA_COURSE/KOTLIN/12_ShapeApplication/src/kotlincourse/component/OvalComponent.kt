package kotlincourse.component

import javax.swing.*
import java.awt.*

class OvalComponent : JComponent() {
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        g.drawOval(5, 5, width - 10, height - 10)
    }
}
