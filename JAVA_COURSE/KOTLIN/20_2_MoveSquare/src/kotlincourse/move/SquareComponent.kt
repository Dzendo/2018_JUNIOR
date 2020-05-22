package kotlincourse.move

import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

// Наш класс умеет получать события от кнопки т.к. реализует интерфейс ActionListener
class SquareComponent : JComponent(), ActionListener {
    // Определяем поля для хранения текущих координат квадрата

        var x11 :Int = 20
        var y11 = 20


    override fun actionPerformed(e: ActionEvent) {
        // Входной параметр содержит ссылку на того, кто послал сообщение.
        // Получает объект с помощью вызова getSource()
        // С помощью слова instanceof мы можем проверить, что объект принадлежит
        // классы JButton (или его потомку)

        if (e.source is JButton) {
            // Приводим объект к типу JButton
            val btn = e.source as JButton
            // Сравниваем команду со строкой UP
            if (MoveSquareFrame.UP == btn.actionCommand) {
                // Вверх двигаемся уменьшением координаты Y
                this.y11 -= STEP
            }
            // Сравниваем команду со строкой DOWN
            if (MoveSquareFrame.DOWN == btn.actionCommand) {
                // Вниз двигаемся увеличением координаты Y
                this.y11 += STEP
            }
            // Перерисовываем компонент для обновления экрана
            repaint()
        }
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        g.drawRect(x11, y11, SQUARE_SIZE, SQUARE_SIZE)
    }

    companion object {
        // Определяем константу для размера квадрата
        private val SQUARE_SIZE = 40
        // Определяем константу для шага
        private val STEP = 20
    }
}
