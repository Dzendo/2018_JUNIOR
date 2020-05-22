package robotkotlin

import robotkotlin.ui.RobotFrame

import javax.swing.*

object RobotManager {

    @JvmStatic
    fun main(args: Array<String>) {
        // Количество сторон многоугольника
        val COUNT = 14
        // Длина стороны
        val SIDE = 100

        val robot = Robot(200.0, 50.0)
        // Установка слушателя для робота
        val srl = SimpleRobotListener()
        robot.setListener(srl)
        // Создаем замкнутую фигуру с количеством углов COUNT
        for (i in 0 until COUNT) {
            robot.forward(SIDE)
            robot.course = robot.course + 360 / COUNT
        }

        // Создаем форму для отрисовки пути нашего робота
        val rf = RobotFrame(robot)
        rf.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        rf.isVisible = true
    }
}
