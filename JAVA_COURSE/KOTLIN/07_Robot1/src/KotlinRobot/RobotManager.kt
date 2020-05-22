package KotlinRobot

object RobotManager {

    @JvmStatic
    fun main(args: Array<String>) {
        // Создаем объекта класса JavaRobot.Robot - теперь с параметрами
        val robot = Robot(20.0, 20.0)

        // Вперед на 20 метров
        robot.forward(20)
        // Напечатать координаты
        robot.printCoordinates()

        // Это более корректный способ менять курс.
        // Реализация внутри робота не сильно отличается, но
        // мы в любой момент сможем сделать более продвинутую версию
        // Но класс JavaRobot.RobotManager об этом даже не узнает
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
    }
}
