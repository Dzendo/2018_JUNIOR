package kotlinrobot

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LV
 */
class Robot {
    // Текущая координата X
    var x = 0.0
        private set
    // Текущая координата Y
    var y = 0.0
        private set
    // Текущий курс (в градусах)
    // Мы ррассмотрим этот метод несколько позже
    var course = 0.0

    // Передвижение на дистанцию distance
    fun forward(distance: Int) {
        // Обращение к полю объекта X
        x = x + distance * Math.cos(course / 180 * Math.PI)
        // Обращение к полю объекта Y
        y = y + distance * Math.sin(course / 180 * Math.PI)
    }

    // Печать координат робота
    fun printCoordinates() {
        println(x.toString() + "," + y)
    }
}
