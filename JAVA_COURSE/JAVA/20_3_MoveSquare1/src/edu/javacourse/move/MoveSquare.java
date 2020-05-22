package edu.javacourse.move;

import javax.swing.JFrame;

public class MoveSquare
{

    public static void main(String[] args)
    {
        // Создаем графическое окно
        MoveSquareFrame msf = new MoveSquareFrame();
        // Задаем правидо, по которому приложение завершиться при 
        // закрытии этой формы
        msf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Делаем окно видимым
        msf.setVisible(true);
    }
}
