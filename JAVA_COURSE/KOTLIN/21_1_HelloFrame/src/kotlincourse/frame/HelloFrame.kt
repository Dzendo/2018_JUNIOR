package kotlincourse.frame

import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class HelloFrame : JFrame() {
    init {
        val btn = JButton("Say 'Hello'")

        // Вот наш пример анонимного класса
        btn.addActionListener { println("Hello, world") }

        // Кладем кнопку на СЕВЕР
        add(btn, BorderLayout.NORTH)
        // Задаем размеры формы
        setBounds(100, 100, 200, 100)
        // Устанавливаем свойство для закрытия приложения
        // при закрытии формы
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        // Делаем форму выидимой
        println("� ����� ����� ��� �� �������")
        isVisible = true
        println("� ����� ����� ��� ����������")
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val hf = HelloFrame()
            val hf1 = HelloFrame()
            val hf2 = HelloFrame()
            println("� � ��� �������� � Main")
        }
    }
}
