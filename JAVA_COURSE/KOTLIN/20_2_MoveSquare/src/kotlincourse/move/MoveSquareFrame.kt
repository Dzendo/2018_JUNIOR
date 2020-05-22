package kotlincourse.move

import javax.swing.*
import java.awt.*

class MoveSquareFrame : JFrame() {
    init {
        val sc = SquareComponent()
        // Кладем компонент для рисования квадрата
        add(sc)

        // Создаем кнопку для посылки команды движения вверх
        val btnUp = JButton(UP)
        // Устанавливаем ей идентификатор, по которому сможем узнать эту кнопку
        btnUp.actionCommand = UP
        // Устанавливаем ей слушатель - компонент для рисования квадрата
        btnUp.addActionListener(sc)
        // Кладем кнопку на самый верх формы - на север
        add(btnUp, BorderLayout.NORTH)

        // Создаем кнопку для посылки команды движения вниз
        val btnDown = JButton(DOWN)
        // Устанавливаем ей идентификатор, по которому сможем узнать эту кнопку
        btnDown.actionCommand = DOWN
        // Устанавливаем ей слушатель - компонент для рисования квадрата
        btnDown.addActionListener(sc)
        // Кладем кнопку на самый низ формы - на юг
        add(btnDown, BorderLayout.SOUTH)

        // Устанавливаем координаты
        setBounds(100, 100, 400, 400)
    }

    companion object {
        val UP = "UP"
        val DOWN = "DOWN"
    }
}
