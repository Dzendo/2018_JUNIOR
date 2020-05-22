/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotlin_simpleclock

/**
 *
 * @author LV
 */

import javax.swing.*
import java.awt.*
import java.text.SimpleDateFormat
import java.util.Calendar

class SimpleClock : JFrame() {
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
        val thr = MyThread(this)
        thr.start()
    }

    fun setTime() {
        // Создаем объект для форматирования даты
        val df = SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
        // Устанавливаем новое значение для метки - сразу форматируем дату в строку и устанавливаем новый текст
        clockLabel.text = df.format(Calendar.getInstance().time)
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val cl = SimpleClock()
            cl.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            cl.isVisible = true
        }
    }
}


internal class MyThread(private val clock: SimpleClock) : Thread() {

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
