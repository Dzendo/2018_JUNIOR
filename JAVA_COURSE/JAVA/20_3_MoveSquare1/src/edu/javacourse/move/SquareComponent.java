package edu.javacourse.move;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;

// Наш класс умеет получать события от кнопки т.к. реализует интерфейс ActionListener
public class SquareComponent extends JComponent implements ActionListener
{
    // Определяем константу для размера квадрата
    private static final int SQUARE_SIZE = 80;
    // Определяем константу для шага
    private static final int STEP = 40;
    // Определяем поля для хранения текущих координат квадрата
    private int x = 40;
    private int y = 40;

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Входной параметр содержит ссылку на того, кто послал сообщение.
        // Получает объект с помощью вызова getSource()
        // С помощью слова instanceof мы можем проверить, что объект принадлежит
        // классы JButton (или его потомку)
        if (e.getSource() instanceof JButton) {
            // Приводим объект к типу JButton
            JButton btn = (JButton) e.getSource();
            // Сравниваем команду со строкой UP
            if (MoveSquareFrame.UP.equals(btn.getActionCommand())) {
                // Вверх двигаемся уменьшением координаты Y
                y -= STEP;
                if (y<0) y=0;
            }
            // Сравниваем команду со строкой DOWN
            if (MoveSquareFrame.DOWN.equals(btn.getActionCommand())) {
                // Вниз двигаемся увеличением координаты Y
                y += STEP;
                // Сюда надо поставить размер окна по Х и по У вместо цифр.
                // А еще потом вычесть из него толщины кнопок и Step
                // Это должны быть методы JFrame типа Get.SIZE 
                if (y>650)y=650;
            }
             // Сравниваем команду со строкой LEFT
            if (MoveSquareFrame.LEFT.equals(btn.getActionCommand())) {
                // Влево двигаемся уменьшением координаты Х
                x -= STEP;
                if (x<0) x=0;
            }
            // Сравниваем команду со строкой RIGHT
            if (MoveSquareFrame.RIGHT.equals(btn.getActionCommand())) {
                // Вправо двигаемся увеличением координаты Х
                x += STEP;
                if (x>550) x=550;
            }
            // Перерисовываем компонент для обновления экрана
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
    }
}
