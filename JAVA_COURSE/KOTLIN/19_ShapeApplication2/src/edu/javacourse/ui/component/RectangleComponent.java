package edu.javacourse.ui.component;

import java.awt.Graphics;

// Класс для рисования прямоугольника
public class RectangleComponent extends AbstractShape
{
    @Override
    protected void paintShape(Graphics g) {
        g.drawRect(5, 5, getWidth() - 10, getHeight() - 10);
    }
}