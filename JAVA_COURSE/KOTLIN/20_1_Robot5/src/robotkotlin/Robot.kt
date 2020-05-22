package robotkotlin

import java.util.ArrayList

class Robot(x: Double, y: Double) {
    var x = 0.0
        private set
    var y = 0.0
        private set
    var course = 0.0
    val lines = ArrayList<RobotLine>()
    // Ссылка на слушателя событий от робота
    // Обратите внимание, что это ссылка на ИНТЕРФЕЙС
    private var listener: RobotListener? = null

    init {
        this.x = x
        this.y = y
    }

    // Метод для установки реального слушателя.
    fun setListener(listener: RobotListener) {
        this.listener = listener
    }

    fun forward(distance: Int) {
        // Вызываем слушателя (если он установлен) в начале
        if (listener != null) {
            listener!!.startMove(x, y)
        }
        // Запоминаем координаты робота перед перемещением
        val xOld = x
        val yOld = y
        // Меняем координаты
        x += distance * Math.cos(course / 180 * Math.PI)
        y += distance * Math.sin(course / 180 * Math.PI)

        // Вызываем слушателя (если он установлен) после остановки
        if (listener != null) {
            listener!!.endMove(x, y)
        }

        // Запоминаем координаты пройденного пути в списке
        // Класс List позволяет добавить объект и хранить его
        lines.add(RobotLine(xOld, yOld, x, y))
    }
}
