package edu.javacourse.ui;

import java.awt.Graphics;
import javax.swing.JComponent;

// Наследуемся от стандартного класса, который
// используется для создания компонентов на форме
public class OvalComponent extends JComponent
{
private int r;
public OvalComponent(int r) {
    this.r=r;
}
    // Переопределяем метод рисованиая, в который передается
    // объект класса Graphics
    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("до super  " + g.hashCode()+ " hash Объекта "+ g.getClass());
        super.paintComponent(g);
        System.out.println("после sup " + g.hashCode()+ " hash Объекта "+ g.getClass());
       
        // Используем Graphics для рисования овала
        // с отступами
        g.drawOval(r, r, getWidth() - r*2, getHeight() - r*2);
    }
    
}
