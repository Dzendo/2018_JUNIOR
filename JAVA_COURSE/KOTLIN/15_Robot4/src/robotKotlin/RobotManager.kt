package robotKotlin

import robotKotlin.ui.RobotFrame

import javax.swing.*

object RobotManager {
    @JvmStatic
    fun main(args: Array<String>) {
        // Количество сторон многоугольника
        val COUNT = 7
        // Длина стороны
        val SIDE = 200

        val robot: Robot
        robot = Robot(200.0, 50.0)
        // Создаем замкнутую фигуру с количеством углов COUNT
        for (i in 0 until COUNT) {
            robot.forward(SIDE)
            robot.course = robot.course + 360 / COUNT
        }

        // Создаем форму для отрисовки пути нашего робота
        val rf: RobotFrame
        rf = RobotFrame(robot)
        rf.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        rf.isVisible = true
    }
}
