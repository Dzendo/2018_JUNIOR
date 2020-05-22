package robotkotlin

// Наш класс реализует интерфейс robotListener
class SimpleRobotListener : RobotListener {

    override fun startMove(x: Double, y: Double) {
        println("Робот начал движение, координаты:$x,$y")
    }

    override fun endMove(x: Double, y: Double) {
        println("Робот закончил движение, координаты:$x,$y")
    }
}
