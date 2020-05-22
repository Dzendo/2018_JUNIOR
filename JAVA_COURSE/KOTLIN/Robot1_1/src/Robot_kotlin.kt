class Robot_kotlin// Теперь конструктор выполняет присваивание. Это удобно.
(x: Double, y: Double) {
    // Текущая координата X
    var x = 0.0
        private set
    // Текущая координата Y
    var y = 0.0
        private set
    // Текущий курс (в градусах)
    var course = 0.0

    init {
        this.x = x
        this.y = y
    }

    // Передвижение на дистанцию distance
    fun forward(distance: Int) {
        // Обращение к полю объекта X
        x = x + distance * Math.cos(course / 180 * Math.PI)
        // Обращение к полю объекта Y
        y = y + distance * Math.sin(course / 180 * Math.PI)
    }

    // Печать координат робота
    fun printCoordinates() {
        println(x.toString() + "," + y)
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {   // Тестовый вызов
            // Создаем объекта класса Robot - теперь с параметрами

            val robot = Robot_kotlin(20.0, 20.0)

            // Вперед на 20 метров
            robot.forward(20)
            // Напечатать координаты
            robot.printCoordinates()

            // Это более корректный способ менять курс.
            // Реализация внутри робота не сильно отличается, но
            // мы в любой момент сможем сделать более продвинутую версию
            // Но класс RobotManager об этом даже не узнает
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
}