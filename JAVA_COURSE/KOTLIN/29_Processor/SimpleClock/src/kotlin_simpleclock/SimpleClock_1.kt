package kotlin_simpleclock

// более правильно с точки зрения

import javax.swing.*
import java.awt.*
import java.text.SimpleDateFormat
import java.util.Calendar

class SimpleClock_1 : JFrame() {
    private val clockLabel = JLabel()

    init {
        // Установить заголовок
        title = "ClockThread"

        // Выравнять метку по горизонтали - есть такой метод у Label
        clockLabel.horizontalAlignment = SwingConstants.CENTER

        // Установить размер шрифта для метки  - есть такой метод у Label
        // Для эт ого создаем шрифт и сразу его отдаем методу setFont
        val f = Font("Default", Font.BOLD + Font.ITALIC, 24)
        clockLabel.font = f

        // Добавить метку на основную панель окна
        contentPane.add(clockLabel)

        // Установить размеры окна
        setBounds(400, 300, 300, 100)

        // ОБРАТИТЬ ВНИМАНИЕ !!!
        // Создаем отдельный поток, который должен обновлять значение метки
        val thr = MyThread_1(this)
        thr.start()
    }

    fun setTime() {
        // Более корректный вызов в отдельном потоке, который отвечает за графику
        SwingUtilities.invokeLater {
            val df = SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
            clockLabel.text = df.format(Calendar.getInstance().time)
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val cl = SimpleClock_1()
            cl.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            cl.isVisible = true
        }
    }
}


internal class MyThread_1(private val clock: SimpleClock_1) : Thread() {

    override fun run() {
        while (true) {
            clock.setTime()
            try {
                Thread.sleep(500)
            } catch (e: Exception) {
            }

        }
    }
}