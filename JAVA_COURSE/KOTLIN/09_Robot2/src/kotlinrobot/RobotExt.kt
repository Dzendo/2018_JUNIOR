package kotlinrobot

class RobotExt(x: Double, y: Double, course: Double) : Robot(x, y) {
    init {
        this.course = course
    }

    fun back(distance: Int) {
        forward(-distance)
    }

    // Печать координат робота
    override fun printCoordinates() {
        println(x.toString() + "," + y + "Это я переопределил метод")
    }
}
