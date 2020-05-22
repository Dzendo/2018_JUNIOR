package kotlincourse.ui

import javax.swing.*

object OvalApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        // Создаем графическое окно
        val of = OvalFrame("Zagolovok DO")
        // Задаем правидо, по которому приложение завершиться при
        // закрытии этой формы
        of.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        // Делаем окно видимым
        of.isVisible = true
    }
}
