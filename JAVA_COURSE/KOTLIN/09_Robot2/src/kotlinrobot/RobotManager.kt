package kotlinrobot

object RobotManager {

    @JvmStatic
    fun main(args: Array<String>) {
        // Создаем объекта класса JavaRobot.RobotExt - X, Y, course
        val robot = RobotExt(0.0, 0.0, 0.0)

        // Вперед на 20 метров
        robot.forward(20)
        // Напечатать координаты
        robot.printCoordinates()

        robot.course = 90.0
        // Вперед на 20 метров
        robot.forward(20)
        // Напечатать координаты
        robot.printCoordinates()

        // Курс 45 градусов
        robot.course = 45.0
        // Вперед на 20 метров
        robot.forward(20)
        // Напечатать координаты
        robot.printCoordinates()
        // И назад на 10 метров
        robot.back(10)
        // Напечатать координаты
        robot.printCoordinates()
    }
}