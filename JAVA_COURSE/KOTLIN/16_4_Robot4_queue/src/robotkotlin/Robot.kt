package robotkotlin

import java.util.ArrayList

class Robot(x: Double, y: Double) {
    internal val HEAD = true   // кладем true - в начало, false - в  конец
    internal val TAIL = false  // берем  true - с начала, false - с  конца
    internal var queue = ObjectQueue()

    var x = 0.0
        private set
    var y = 0.0
        private set
    var course = 0.0
    // Список для хранения линий, по которым перемещался робот
    // Пока будем использовать его без подробностей
    val lines = ArrayList<RobotLine>()

    init {
        this.x = x
        this.y = y
        queue.FIFO_LIFO(TAIL, HEAD)
    }

    fun forward(distance: Int) {
        // Запоминаем координаты робота перед перемещением
        val xOld = x
        val yOld = y
        // Меняем координаты
        x += distance * Math.cos(course / 180 * Math.PI)
        y += distance * Math.sin(course / 180 * Math.PI)
        // Запоминаем координаты пройденного пути в списке
        // Класс List позволяет добавить объект и хранить его
        lines.add(RobotLine(xOld, yOld, x, y))
        queue.push(RobotLine(xOld, yOld, x, y))
    }

    /* public ArrayList<RobotLine> getLines() {
        return (RobotLine)queue.pull();
        //return lines;
    } */
    fun getLines(): RobotLine {
        return queue.pull() as RobotLine
        //return lines;
    }
}
