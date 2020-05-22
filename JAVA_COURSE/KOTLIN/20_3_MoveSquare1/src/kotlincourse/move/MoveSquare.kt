package kotlincourse.move

import javax.swing.*

object MoveSquare {

    @JvmStatic
    fun main(args: Array<String>) {
        // Создаем графическое окно
        val msf = MoveSquareFrame()
        // Задаем правидо, по которому приложение завершиться при
        // закрытии этой формы
        msf.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        // Делаем окно видимым
        msf.isVisible = true
    }
}
