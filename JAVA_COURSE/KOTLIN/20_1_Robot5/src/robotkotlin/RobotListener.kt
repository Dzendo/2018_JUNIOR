package robotkotlin

/**
 * Интерфейс слушателя событий от робота
 */
interface RobotListener {
    // Метод будет вызываться в момент начала движения
    fun startMove(x: Double, y: Double)

    // Метод будет вызываться в момент окончания движения
    fun endMove(x: Double, y: Double)
}
