package edu.javacourse.ui;

import javax.swing.JFrame;

public class ShapeApplication
{
    public static void main(String[] args) {
        // Создаем графическое окно
        ShapeFrame of = new ShapeFrame();
        // Задаем правидо, по которому приложение завершиться при 
        // закрытии этой формы
         of.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       
         //for (int i1=0; i1<32000; i1++) System.out.println("===========");
        // Делаем окно видимым
        of.setVisible(true);
        //for (int i1=0; i1<32000; i1++) System.out.println("===========");
        // of.setVisible(true);
    }
}
