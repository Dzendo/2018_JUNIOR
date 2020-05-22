package edu.javacourse;

// Мы ИМПОРТИРОВАЛИ класс из пакета
import javax.swing.JFrame;

public class SimpleFrame {

    public static void main(String[] args) {
         jButton2 = new javax.swing.JButton();
        // Создали экземпляр класса - объект
        JFrame sf = new JFrame();
        
         jButton2.setText("<html><p align=center>OK</p>Выход из программы");
        // Установим заголовок
        sf.setTitle("Мое Окно");
        // Установим свойсво - завершить приложение при закрытии окна
        sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Выставим координаты и размеры 
        // Верхний левый угол - первые два числа 100 и 100
        // Ширина и высота - вторы два числа 400 и 200
        sf.setBounds(200, 200, 600, 400);
        // Отобразим окно, сделав его видимым
        //String SSS="AAAA";
         //sf.add(SSS);
        sf.setVisible(true);
         JFrame sf1 = new JFrame();
        // Установим заголовок
        sf1.setTitle("Мое Окно1");
        // Установим свойсво - завершить приложение при закрытии окна
        sf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Выставим координаты и размеры 
        // Верхний левый угол - первые два числа 100 и 100
        // Ширина и высота - вторы два числа 400 и 200
        sf1.setBounds(600, 600, 800, 400);
        sf.add(jButton2);
        
        // Отобразим окно, сделав его видимым
        //String SSS="AAAA";
         //sf.add(SSS);
        sf.setVisible(true);
         sf1.setVisible(true);
        // Теперь у нас на экране появилось окно, которым
        // можно управлять - перетаскивать, менять размеры.
        // Разве не красиво ?
    }
     private static javax.swing.JButton jButton2;
}
