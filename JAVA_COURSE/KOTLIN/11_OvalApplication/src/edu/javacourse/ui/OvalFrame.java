package edu.javacourse.ui;

import javax.swing.JFrame;

public class OvalFrame extends JFrame
{
    public OvalFrame(String s) {
        // Создаем объект типа OvalComponent
        super(s);
        OvalComponent oc = new OvalComponent(50);
        // Испольщзуем метод класса JFrame для добавления
        // компонента на главную панель.
        add(oc);
        OvalComponent oc1 = new OvalComponent(5);
         add(oc1);
        // Устанавливаем координаты и размеры окна
        setBounds(200, 200, 300, 250);
    }
    
}
