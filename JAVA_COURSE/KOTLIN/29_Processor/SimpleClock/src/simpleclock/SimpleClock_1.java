package simpleclock;
// более правильно с точки зрения  
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
        // Установить заголовок
        setTitle("ClockThread");
 
        // Выравнять метку по горизонтали - есть такой метод у Label
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
 
        // Установить размер шрифта для метки  - есть такой метод у Label
        // Для эт ого создаем шрифт и сразу его отдаем методу setFont
        Font f = new Font("Default", Font.BOLD + Font.ITALIC, 24);
        clockLabel.setFont(f);
 
        // Добавить метку на основную панель окна
        getContentPane().add(clockLabel);
 
        // Установить размеры окна
        setBounds(400, 300, 300, 100);
 
        // ОБРАТИТЬ ВНИМАНИЕ !!!
        // Создаем отдельный поток, который должен обновлять значение метки
        Thread thr = new MyThread_1(this);
        thr.start();
    }
    
    public void setTime() {
        // Более корректный вызов в отдельном потоке, который отвечает за графику
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