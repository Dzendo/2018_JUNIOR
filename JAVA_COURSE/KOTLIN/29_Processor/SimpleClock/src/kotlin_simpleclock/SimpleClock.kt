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
        // ���������� ���������
        title = "ClockThread"

        // ��������� ����� �� ����������� - ���� ����� ����� � Label
        clockLabel.horizontalAlignment = SwingConstants.CENTER

        // ���������� ������ ������ ��� �����  - ���� ����� ����� � Label
        // ��� �� ��� ������� ����� � ����� ��� ������ ������ setFont
        val f = Font("Default", Font.BOLD + Font.ITALIC, 24)
        clockLabel.font = f

        // �������� ����� �� �������� ������ ����
        contentPane.add(clockLabel)

        // ���������� ������� ����
        setBounds(400, 300, 300, 100)

        // �������� �������� !!!
        // ������� ��������� �����, ������� ������ ��������� �������� �����
        val thr = MyThread(this)
        thr.start()
    }

    fun setTime() {
        // ������� ������ ��� �������������� ����
        val df = SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
        // ������������� ����� �������� ��� ����� - ����� ����������� ���� � ������ � ������������� ����� �����
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
