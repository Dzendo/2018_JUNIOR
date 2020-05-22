package robotkotlin.ui

import robotkotlin.Robot

import javax.swing.*

class RobotFrame(robot: Robot) : JFrame() {
    init {
        // Устанавливаем заголовок окна
        title = "Robot Frame"
        // Добавляем компонент для рисования пути робота
        add(RobotPathComponent(robot))
        // Устанавливаем размеры окна
        setBounds(100, 100, 600, 600)
    }

}
