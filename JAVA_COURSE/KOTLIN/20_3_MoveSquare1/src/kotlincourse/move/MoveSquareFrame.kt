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

        // Создаем кнопку для посылки команды движения влево
        val btnLeft = JButton(LEFT)
        // Устанавливаем ей идентификатор, по которому сможем узнать эту кнопку
        btnLeft.actionCommand = LEFT
        // Устанавливаем ей слушатель - компонент для рисования квадрата
        btnLeft.addActionListener(sc)
        // Кладем кнопку на самый левый край формы - на запад
        add(btnLeft, BorderLayout.WEST)

        // Создаем кнопку для посылки команды движения вправо
        val btnRight = JButton(RIGHT)
        // Устанавливаем ей идентификатор, по которому сможем узнать эту кнопку
        btnRight.actionCommand = RIGHT
        // Устанавливаем ей слушатель - компонент для рисования квадрата
        btnRight.addActionListener(sc)
        // Кладем кнопку на самый правый край формы - на восток
        add(btnRight, BorderLayout.EAST)

        // Устанавливаем координаты
        setBounds(100, 100, 800, 800)
    }

    companion object {
        val UP = "UP"
        val DOWN = "DOWN"
        val LEFT = "LEFT"
        val RIGHT = "RIGHT"
    }
}
