package kotlincourse.move

import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

// Наш класс умеет получать события от кнопки т.к. реализует интерфейс ActionListener
class SquareComponent : JComponent(), ActionListener {
    // Определяем поля для хранения текущих координат квадрата
    private var x11 = 40
    private var y11 = 40

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
                y11 -= STEP
                if (y11 < 0) y11 = 0
            }
            // Сравниваем команду со строкой DOWN
            if (MoveSquareFrame.DOWN == btn.actionCommand) {
                // Вниз двигаемся увеличением координаты Y
                y11 += STEP
                // Сюда надо поставить размер окна по Х и по У вместо цифр.
                // А еще потом вычесть из него толщины кнопок и Step
                // Это должны быть методы JFrame типа Get.SIZE
                if (y11 > 650) y11 = 650
            }
            // Сравниваем команду со строкой LEFT
            if (MoveSquareFrame.LEFT == btn.actionCommand) {
                // Влево двигаемся уменьшением координаты Х
                x11 -= STEP
                if (x11 < 0) x11 = 0
            }
            // Сравниваем команду со строкой RIGHT
            if (MoveSquareFrame.RIGHT == btn.actionCommand) {
                // Вправо двигаемся увеличением координаты Х
                x11 += STEP
                if (x11 > 550) x11 = 550
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
        private val SQUARE_SIZE = 80
        // Определяем константу для шага
        private val STEP = 40
    }
}
