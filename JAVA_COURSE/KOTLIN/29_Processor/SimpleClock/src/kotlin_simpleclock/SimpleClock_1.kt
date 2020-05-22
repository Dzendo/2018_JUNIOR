package kotlin_simpleclock

// ����� ��������� � ����� ������

import javax.swing.*
import java.awt.*
import java.text.SimpleDateFormat
import java.util.Calendar

class SimpleClock_1 : JFrame() {
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
        val thr = MyThread_1(this)
        thr.start()
    }

    fun setTime() {
        // ����� ���������� ����� � ��������� ������, ������� �������� �� �������
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