package edu.javacourse.robot;

import java.util.ArrayList;
import java.util.List;

public class Robot
{
    final boolean HEAD  =true;   // кладем true - в начало, false - в  конец
    final boolean TAIL  =false;  // берем  true - с начала, false - с  конца
    ObjectQueue queue = new ObjectQueue();
    
    private double x = 0;
    private double y = 0;
    protected double course = 0;
    // Список для хранения линий, по которым перемещался робот
    // Пока будем использовать его без подробностей
    private ArrayList<RobotLine> lines = new ArrayList<RobotLine>();

    public Robot(double x, double y) {
        this.x = x;
        this.y = y; 
    queue.FIFO_LIFO(TAIL, HEAD);
    }

    public void forward(int distance) {
        // Запоминаем координаты робота перед перемещением
        final double xOld = x;
        final double yOld = y;
        // Меняем координаты
        x += distance * Math.cos(course / 180 * Math.PI);
        y += distance * Math.sin(course / 180 * Math.PI);
        // Запоминаем координаты пройденного пути в списке
        // Класс List позволяет добавить объект и хранить его
        lines.add(new RobotLine(xOld, yOld, x, y));
        queue.push(new RobotLine(xOld, yOld, x, y));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

   /* public ArrayList<RobotLine> getLines() {
        return (RobotLine)queue.pull();
        //return lines; 
    } */
     public RobotLine getLines() {
        return (RobotLine) queue.pull();
        //return lines; 
    } 
}
