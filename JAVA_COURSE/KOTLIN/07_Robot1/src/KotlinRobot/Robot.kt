package KotlinRobot

class Robot// Теперь конструктор выполняет присваивание. Это удобно.
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
}