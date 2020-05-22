package robotkotlin.ui

import robotkotlin.Robot
import robotkotlin.RobotLine

import javax.swing.*
import java.awt.*

class RobotPathComponent(private val robot: Robot) : JComponent() {

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        // Перебираем все линии, которые сохранились у робота
        // Несколько позже мы разберем эту конструкицю подробно
        for (rl in robot.lines) {
            // Для каждой линии получаем координаты
            val x1 = Math.round(rl.x1).toInt()
            val y1 = Math.round(rl.y1).toInt()
            val x2 = Math.round(rl.x2).toInt()
            val y2 = Math.round(rl.y2).toInt()
            // И рисуем линию с координатами
            g.drawLine(x1, y1, x2, y2)
        }
    }
}
