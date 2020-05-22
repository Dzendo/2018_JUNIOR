package kotlincourse

import javax.swing.*

object ShapeApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        // Создаем графическое окно
        val of = ShapeFrame()
        // Задаем правидо, по которому приложение завершиться при
        // закрытии этой формы
        of.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        // Делаем окно видимым
        of.isVisible = true
    }
}
