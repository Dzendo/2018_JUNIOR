package robotkotlin

class Robot(x: Double, y: Double) {
    var x = 0.0
        private set
    var y = 0.0
        private set
    var course = 0.0

    init {
        this.x = x
        this.y = y
    }

    // Передвижение на дистанцию distance
    fun forward(distance: Int) {
        x = x + distance * Math.cos(course / 180 * Math.PI)
        y = y + distance * Math.sin(course / 180 * Math.PI)
    }

    // Печать координат робота
    fun printCoordinates() {
        println(x.toString() + "," + y)
    }
}
