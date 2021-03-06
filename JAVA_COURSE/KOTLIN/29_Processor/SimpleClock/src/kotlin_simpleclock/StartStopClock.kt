package kotlin_simpleclock

import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.text.SimpleDateFormat
import java.util.Calendar

class StartStopClock : JFrame(), ActionListener {

    private val clockLabel = JLabel()
    private var clockThread: ClockThread? = null

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
        add(clockLabel)

        // �������� ������ ��� ������
        val start = JButton(START)
        start.actionCommand = START
        start.addActionListener(this)
        add(start, BorderLayout.NORTH)

        // �������� ������ ��� ��������
        val stop = JButton(STOP)
        stop.actionCommand = STOP
        stop.addActionListener(this)
        add(stop, BorderLayout.SOUTH)

        // ���������� ������� ����
        setBounds(400, 300, 300, 200)

    }

    fun setTime() {
        // ����� ���������� ����� � ��������� ������, ������� �������� �� �������
        SwingUtilities.invokeLater {
            val df = SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
            clockLabel.text = df.format(Calendar.getInstance().time)
        }
    }

    override fun actionPerformed(ae: ActionEvent) {
        if (START == ae.actionCommand) {
            if (clockThread == null) {
                clockThread = ClockThread(this)
                clockThread!!.start()
            }
        }
        if (STOP == ae.actionCommand) {
            if (clockThread != null) {
                clockThread!!.stopClock()
                clockThread = null
            }
        }
    }

    companion object {
        private val START = "START"
        private val STOP = "STOP"

        @JvmStatic
        fun main(args: Array<String>) {
            val cl = StartStopClock()
            cl.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            cl.isVisible = true
        }
    }
}


internal class ClockThread(private val clock: StartStopClock) : Thread() {
    @Volatile
    private var isRunning = true

    fun stopClock() {
        isRunning = false
    }

    override fun run() {
        while (isRunning) {
            clock.setTime()
            try {
                Thread.sleep(500)
            } catch (e: Exception) {
            }

        }
    }
}
/* 
������ � ������ main. � ��� �� ������� ���� �����, ���������� �� �����������
��������, ������� ���������� ������ ���������� ��� �������� ����� � ������ ����
����� ������� (������ 84-86).
����� ���������� ����������� (������ 24-52). 
� ��� ����� ������ � ��� ������ 39-48). 
����� �� ������� ��� ������ START � STOP. 
������ � ���� ����������� �����������, ������� ���������� ������ ������ START.
������� �� ������� ������. ����� start.setActionCommand(START) �������������
���������� ������������� �������, ������� ����� ��������� ����������. 
��������� ����� start.addActionListener(this) ������������ ���� �����
StartStopClock � �������� ��������� � ������ (�� ������ ����� ������),
�� ����� �� ������ �� ������� ��� ��� ������ � ������ ��� ������� �� ���
��������� ������ ����� ���������� � ������� �������� ��������� ���� ActionEvent.
��� ����� ���� ������ ������ ������, �� ������ �� ��� ������ �����������
��������� ActionListener, ��� ���� ����� � ������ � � ��� ���� �����
actionPerformed.
����� �������, ��� ������ ������� � ����, ��� �� ����� ������� �������� 
� ��� ������ �� ������, ��� ���� ���������. ������������ ���������� � ����,
���� ���� ��������� � � ���� ������ ���� ������� � ����� actionPerformed.
� �������������� ����� �� ������� ���� ������ �� ����� ������� add, � ������� 
�������� ������ � ������ ���������� ��������� �� �������������� �� ����� � 
��� ������ START ��� ����� (NORTH).
���� ����� ������ � ������ ��� ������� ������� ��� ���� ������ ������� �����
��������� � ����� actionPerformed. ������� ��� ���������� � ������ 68-81).
����� ������ �������� ���� �����, ��� �������� ��� ����������� ������
(ActionEvent), ������� ��������� ������� (��� ���������). 
��� � ���� ������� ���������� ������ ������������� ������� 
(�� ��� ���������� ������� setActionCommand. ���� ������ ������ START, 
�� �� ������� �����, ��� � ������ ��� ������ � ������ ���������. 
�������� �� null ��������� ��� �������� �������� ������� 
(���������� ������ ��� �������� � ����������� ������ START �������� ��� ������
� ����� ���������� ���������� ���� ���� ������� STOP).
������ STOP ��������� ��� ��������� � ������ ������ ������ 
� �������� � ���� ����� stopClock(), ������� ��� ��� � ������������ ��� ����,
����� �� ����� �������� ������, ��� ����� ��� ����������/����������.
� ������� ����� ������� �������� ������ ���������� � ����� ClockThread.
��� ��� �� ������ ������, ��� ���������� ������ �� ����� � ������
� � ������ run �� � ����� ������������� �������� ����� setTime().
��� �� ��� ������, �� �������� ����������� ���������� isRunning,
������� � ����������, ���������� �� ��� ���� ��� ���.
� ������ ������ ���� ������� ����� stopClock(), ������� �������������
�������� ���������� isRunning � false � ��� ����� ���������� ����. 
��� ����� ������ � ��������� � �� ��������� ����� ������������ � ��,
�������� ��������� ���, �������� ��� ������.
��� ����� ����� � �� ���� ������ ����������� ������� ��� �����������,
����� ����������� ��������� � ���� � �������� ������ ����� (��� �������)
��� ����������� ������ � ������������ �� ����-�� ����������. 
���������� ����, ��� �� ��� ����� ���������� � �� �� �� ����� ��������
��������� ������ ������ ������. ��� �����. 
������� � ������������ ������ ��� �������.
�������� �������������� ���������.
�� ��������� �������� �������� �� ����� volatile � ������ �������� �����
���������� isRunning (��� ����� ��������� ��� �������������, �����������).
��� ����� ������������, ����� ���������� JVM � ��������� � ���� ����������
����� ������������ �� ������ �������, ��� � ��� � ���������� � ���� �����
������ ��������� �����, � ������ ���������� ��� ������� �� ������.
��� ���������� � ���� ����������. �� ����� ��� ���� JVM ?
���� � ���, ��� ����� ���������� �����������, JVM ��������� ��������
�������������� ��� ����������. 
� ������ ��� ��������, � ������ ������� ����� ����������
�� ���� ��� ����� ���������� isRunning. ��� �� ������ ����������, �� ���������.
����� ������� ����� ���������� ��������, ��� ����� �� ������ ������� ���� �����,
� �����, ������� ������ ���� � ������ ������ ����������, ����� ������������
������ ����� � � ������� �� �����������.
����� ������ ��������� ����� �� �����������, �� ������������ JVM, ����� ���
��������� �������� �� ���� ���������� � ���� ��������� ��� �����������. 
��� ���������� � ���.

*/