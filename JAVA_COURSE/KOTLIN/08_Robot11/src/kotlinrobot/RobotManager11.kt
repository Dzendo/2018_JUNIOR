package kotlinrobot

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LV
 */
class RobotManager11 {

    private fun changeCourse(robot: Robot) {
        var robot = robot
        robot = Robot()
        robot.course = 180.0
    }

    companion object {

        /**
         * @param args the command line arguments
         */
        @JvmStatic
        fun main(args: Array<String>) {
            // Создаем объект для управления роботом
            val rm = RobotManager11()

            // Создаем объекта класса javarobot.Robot
            val robot = Robot()
            // Курс 45 градусов
            robot.course = 45.0
            // Напечатать курс
            println(robot.course)      // Здесь будет 45

            // вызываем метод и передаем туда робота
            rm.changeCourse(robot)

            // Напечатать курс
            println(robot.course)      // Здесь будет 180
        }
    }
}
    
