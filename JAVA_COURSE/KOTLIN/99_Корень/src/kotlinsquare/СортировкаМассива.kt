package kotlinsquare

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LV
 */
import java.lang.Math.*
import java.util.Scanner

object СортировкаМассива {
    internal var массив: IntArray  ={35,24,12,2,8,74,13,99,454,12,44};
    internal var n: Int = 0
    internal var м: Int = 0
    internal var флаг: Boolean = false
    internal var start: Long = 0
    internal var end: Long = 0
    internal var delta: Long = 0
    @JvmStatic
    fun main(Аргументы: Array<String>) {
        // n=50;
        n = 20 //Inputt(" ВВедите n=");


        println(" Лена прожила " + end + " милисек;  вычисляли  " + (end - start) + " т.е = " + delta + " сек")
        массив = IntArray(n)
        start = System.currentTimeMillis()
        for (i in 0 until n) массив[i] = (Math.random() * n).toInt()
        // печать();
        while (true) {
            флаг = true
            for (i in 0 until n - 1) {
                if (массив[i] > массив[i + 1]) {
                    м = массив[i]
                    массив[i] = массив[i + 1]
                    массив[i + 1] = м
                    флаг = false
                }
            }
            if (флаг) break
        }
        // печать();
        end = System.currentTimeMillis()
        delta = end - start
        delta /= 1000
        println(" Лена прожила " + end + " милисек;  вычисляли  " + (end - start) + " т.е = " + delta + " сек")
        println(" Лена прожила " + end + " милисек = " + end / 1000 + " сек = " + end / 60000 + " часов = " + end / (24 * 60 * 1000) + " дней ")
    }

    internal fun печать() {
        for (i in 0 until n) print(" " + массив[i])
        println()
    }

    internal fun Inputt(ss: String): Int {
        val input = Scanner(System.`in`)
        while (true) {
            print(ss)
            if (input.hasNextInt())
            // возвращает истинну если с потока ввода можно считать целое число
                return input.nextInt()
            println("Вы ввели не число")
            input.nextLine()  // очистил ввод
        }  // конец for
    } // конец inputt
}
