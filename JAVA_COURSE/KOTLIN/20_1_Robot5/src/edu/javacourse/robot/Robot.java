package edu.javacourse.robot;

import java.util.ArrayList;

public class Robot
{
    private double x = 0;
    private double y = 0;
    protected double course = 0;
    private ArrayList<RobotLine> lines = new ArrayList<RobotLine>();
    // Ссылка на слушателя событий от робота
    // Обратите внимание, что это ссылка на ИНТЕРФЕЙС
    private RobotListener listener;
    
    public Robot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Метод для установки реального слушателя.
    public void setListener(RobotListener listener) {
        this.listener = listener;
    }
    
    public void forward(int distance) {
        // Вызываем слушателя (если он установлен) в начале
        if(listener !=null) {
            listener.startMove(x, y);
        }
        // Запоминаем координаты робота перед перемещением
        final double xOld = x;
        final double yOld = y;
        // Меняем координаты
        x += distance * Math.cos(course / 180 * Math.PI);
        y += distance * Math.sin(course / 180 * Math.PI);

        // Вызываем слушателя (если он установлен) после остановки
        if(listener !=null) {
            listener.endMove(x, y);
        }

        // Запоминаем координаты пройденного пути в списке
        // Класс List позволяет добавить объект и хранить его
        lines.add(new RobotLine(xOld, yOld, x, y));
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

    public ArrayList<RobotLine> getLines() {
        return lines;
    }
}
