/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LV
 */
public class RobotManager11 {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) {
        // Создаем объект для управления роботом
        RobotManager11 rm = new RobotManager11();
 
        // Создаем объекта класса Robot
        Robot robot = new Robot();
        // Курс 45 градусов
        robot.setCourse(45);
        // Напечатать курс
        System.out.println(robot.getCourse());      // Здесь будет 45
 
        // вызываем метод и передаем туда робота
        rm.changeCourse(robot);
 
        // Напечатать курс
        System.out.println(robot.getCourse());      // Здесь будет 180
    }
 
    private void changeCourse(Robot robot) {
       robot = new Robot();
        robot.setCourse(180);
    }
    }
    
