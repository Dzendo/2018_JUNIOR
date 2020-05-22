package simpleclock;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
 
public class StartStopClock extends JFrame implements ActionListener
{
    private static final String START = "START";
    private static final String STOP = "STOP";
    
    private final JLabel clockLabel = new JLabel();
    private ClockThread clockThread = null;
    
    public StartStopClock() {
        // Установить заголовок
        setTitle("ClockThread");
 
        // Выравнять метку по горизонтали - есть такой метод у Label
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
 
        // Установить размер шрифта для метки  - есть такой метод у Label
        // Для эт ого создаем шрифт и сразу его отдаем методу setFont
        Font f = new Font("Default", Font.BOLD + Font.ITALIC, 24);
        clockLabel.setFont(f);
 
        // Добавить метку на основную панель окна
        add(clockLabel);
        
        // Добавить кнопку для старта
        JButton start = new JButton(START);
        start.setActionCommand(START);
        start.addActionListener(this);
        add(start, BorderLayout.NORTH);
        
        // Добавить кнопку для становки
        JButton stop = new JButton(STOP);
        stop.setActionCommand(STOP);
        stop.addActionListener(this);
        add(stop, BorderLayout.SOUTH);
 
        // Установить размеры окна
        setBounds(400, 300, 300, 200);
 
    }
    
    public void setTime() {
        // Более корректный вызов в отдельном потоке, который отвечает за графику
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                clockLabel.setText(df.format(Calendar.getInstance().getTime()));
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(START.equals(ae.getActionCommand())) {
            if(clockThread == null) {
                clockThread = new ClockThread(this);
                clockThread.start();
            }
        }
        if(STOP.equals(ae.getActionCommand())) {
            if(clockThread != null) {
                clockThread.stopClock();
                clockThread = null;
            }
        }
    }
 
    public static void main(String[] args) {
        StartStopClock cl = new StartStopClock();
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl.setVisible(true);
    }
}
 
 
class ClockThread extends Thread {
 
    private StartStopClock clock;
    private volatile boolean isRunning = true;
 
    public ClockThread(StartStopClock clock) {
        this.clock = clock;
    }
    
    public void stopClock() {
        isRunning = false;
    }
 
    @Override
    public void run() {
        while (isRunning) {
            clock.setTime();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}
/* 
Начнем с метода main. В нем мы создаем нашу форму, выставляем ей специальное
свойство, которое прекращает работу приложения при закрытии формы и делает нашу
форму видимой (строки 84-86).
Далее рассмотрим конструктор (строки 24-52). 
В нем самое важное — это строки 39-48). 
Здесь мы создаем две кнопки START и STOP. 
Работа с ними практически оддинаковая, поэтому рассмотрим только кнопку START.
Сначала мы создаем кнопку. Вызов start.setActionCommand(START) устанавливает
уникальный идентификатор команды, который будет отправлен слушаютелю. 
Следующий вызов start.addActionListener(this) регистрирует нашу форму
StartStopClock в качестве слушателя у кнопки (мы раньше такое видели),
но чтобы не бегать по статьям еще раз опишем — кнопка при нажатии на нее
проверяет список своих слушателей и каждому посылает сообщение типа ActionEvent.
Они могут быть какого угодно класса, но каждый из них должен реализовать
интерфейс ActionListener, что наша форма и делает — у нее есть метод
actionPerformed.
Можно сказать, что кнопка собрала у всех, кто ее хотел слушать телефоны 
и как только ее нажали, она всем позвонила. Елинственное требование к тому,
кому надо позвонить — у него должен быть телефон — метод actionPerformed.
И заключительным шагом мы «кладем» нашу кнопку на форму методом add, в котором 
передаем кнопку и вторым параметром указываем ее местоположение на форме — 
для кнопки START это север (NORTH).
Наша форма готова и кнопки при нажатии вызовут еще один важный жлемент нашей
программы — метод actionPerformed. Смотрми его реализацию — строки 68-81).
Когда кнопка вызывает этот метод, она передает ему специальный объект
(ActionEvent), который описывает событие (его параметры). 
Нас в этом событии интересует только идентификатор команды 
(мы его установили методом setActionCommand. Если нажали кнопку START, 
то мы создаем поток, как и раньше это делали — ничего собенного. 
Проверка на null позволяет нам избежать двойного запуска 
(попробуйте убрать эту проверку и понажимайте кнопку START нсколько раз подряд
— потом попробуйте остановить наши часы кнопкой STOP).
Кнопка STOP позволяет нам обратится к нашему классу потока 
и вызывать у него метод stopClock(), который как раз и предназначен для того,
чтобы мы могли сообщить потоку, что хотим его остановить/прекратить.
И наконец самый главный участник нашего приложения — класс ClockThread.
Как уже мы видели раньше, ему передается ссылка на форму с часами
и в методе run он в цикле переодиччески вызывает метод setTime().
Как вы уже видите, мы добавили специальную переменную isRunning,
которая и определяет, продолжать ли наш цикл или нет.
У нашего класса есть простой метод stopClock(), который устанавливает
значение переменной isRunning в false и тем самым прекращает цикл. 
Все очень просто и элегантно — мы попросили поток остановиться и он,
завершив очередной шаг, спокойно это сделал.
Это очень важно — МЫ ДАЛИ потоку ВОЗМОЖНОСТЬ сделать все необходимое,
чтобы завершиться корректно — ведь в процессе работы поток (для примера)
мог накапливать данные и переодически их куда-то записывать. 
Представим себе, что мы его грубо остановили и он бы не успел записать
очередную порцию важных данных. Это плохо. 
Поэтому и предлагается именно наш вариант.
Осталось заключительное замечание.
Вы наверняка обратили внимание на слово volatile в строке описания нашей
переменной isRunning (его можно перевести как «непостоянный», «изменчивый»).
Это слово используется, чтобы подсказать JVM — обращение к этой переменной
может производится из разных потоков, что у нас и получается — один поток
меняет показания часов, а другой вызывается при нажатии на кнопку.
Оба обращаются к этой переменной. Но зачем это надо JVM ?
Дало в том, что когда приложение выполняется, JVM постоянно пытается
оптимизировать его исполнение. 
И иногда для скорости, в разных потоках может возникнуть
по сути две копии переменной isRunning. Это не всегда происходит, но случается.
Таким образом может возникнуть ситуация, что поток от кнопки изменит одну копию,
а поток, который меняет часы и только читает переменную, будет использовать
другую копию — и никогда не остановится.
Чтобы такого абсолютно точно не происходило, мы подсказываем JVM, чтобы она
«обратила внимание» на нашу переменную и была осторожна при оптимизации. 
Вот собственно и все.

*/