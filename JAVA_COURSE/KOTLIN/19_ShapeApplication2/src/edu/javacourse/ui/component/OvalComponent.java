package edu.javacourse.ui.component;

import java.awt.Graphics;

// Класс для рисования овала
public class OvalComponent extends AbstractShape
{
    @Override
    protected void paintShape(Graphics g) {
        g.drawOval(5, 5, getWidth() - 10, getHeight() - 10);
    }
}
