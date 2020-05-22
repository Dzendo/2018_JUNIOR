package kotlincourse.component

import javax.swing.*
import java.awt.*

abstract class AbstractShape : JComponent() {
    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        paintShape(g)
    }

    protected abstract fun paintShape(g: Graphics)
}
