package robotkotlin

object RobotManager {
    @JvmStatic
    fun main(args: Array<String>) {
        // Объявление массива и создание
        val rbts = arrayOfNulls<Robot>(10)

        // Обратите внимание на запись rbts.length - это свойство
        // (неизменяемое) возращает размер массива
        for (i in rbts.indices) {
            // Создаем обхект типа Robot
            rbts[i] = Robot((i * 10).toDouble(), (i * 10).toDouble())
        }

        // Еще один цикл, который вызывает печать координат у каждого робота
        for (i in rbts.indices) {
            rbts[i]?.printCoordinates()
        }
    }
}
