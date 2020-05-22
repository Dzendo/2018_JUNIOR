package javarobot;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LV
 */
public class Robot {
    // Текущая координата X
    private double x = 0;
    // Текущая координата Y
    private double y = 0;
    // Текущий курс (в градусах)
    private double course = 0;
 
    // Передвижение на дистанцию distance
    public void forward(int distance) {
        // Обращение к полю объекта X
        x = x + distance * Math.cos(course / 180 * Math.PI);
        // Обращение к полю объекта Y
        y = y + distance * Math.sin(course / 180 * Math.PI);
    }
 
    // Печать координат робота
    public void printCoordinates() {
        System.out.println(x + "," + y);
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
 
    // Мы ррассмотрим этот метод несколько позже
    public void setCourse(double course) {
        this.course = course;
    }
}
