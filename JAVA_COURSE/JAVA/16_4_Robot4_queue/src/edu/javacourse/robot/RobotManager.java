package edu.javacourse.robot;

import edu.javacourse.robot.ui.RobotFrame;
import javax.swing.JFrame;

public class RobotManager
{
    public static void main(String[] args) {
        // Количество сторон многоугольника
        final int COUNT = 7;
        // Длина стороны
        final int SIDE = 200;
        
        Robot robot;
        robot = new Robot(200, 50);
        // Создаем замкнутую фигуру с количеством углов COUNT
        for (int i = 0; i < COUNT; i++) {
            robot.forward(SIDE);
            robot.setCourse(robot.getCourse() + 360 / COUNT);
        }

        // Создаем форму для отрисовки пути нашего робота
        RobotFrame rf;
        rf= new RobotFrame(robot);
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rf.setVisible(true);
    }
}
