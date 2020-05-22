package simpleclock;
// ����� ��������� � ����� ������  
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
 
public class SimpleClock_1 extends JFrame
{
    private JLabel clockLabel = new JLabel();
    
    public SimpleClock_1() {
        // ���������� ���������
        setTitle("ClockThread");
 
        // ��������� ����� �� ����������� - ���� ����� ����� � Label
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
 
        // ���������� ������ ������ ��� �����  - ���� ����� ����� � Label
        // ��� �� ��� ������� ����� � ����� ��� ������ ������ setFont
        Font f = new Font("Default", Font.BOLD + Font.ITALIC, 24);
        clockLabel.setFont(f);
 
        // �������� ����� �� �������� ������ ����
        getContentPane().add(clockLabel);
 
        // ���������� ������� ����
        setBounds(400, 300, 300, 100);
 
        // �������� �������� !!!
        // ������� ��������� �����, ������� ������ ��������� �������� �����
        Thread thr = new MyThread_1(this);
        thr.start();
    }
    
    public void setTime() {
        // ����� ���������� ����� � ��������� ������, ������� �������� �� �������
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                clockLabel.setText(df.format(Calendar.getInstance().getTime()));
            }
        });
    }
    
    public static void main(String[] args) {
        SimpleClock_1 cl = new SimpleClock_1();
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl.setVisible(true);
    }
}
 
 
class MyThread_1 extends Thread {
 
    private SimpleClock_1 clock;
 
    public MyThread_1(SimpleClock_1 clock) {
        this.clock = clock;
    }
 
    @Override
    public void run() {
        while (true) {
            clock.setTime();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}