/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testvariablekotlin

/**
 *
 * @author LV
 */
class TestVariable {

    fun testMethod(first: Double) {
        var first = first
        println("Test method:$first")      // Здесь мы увидим 99
        first = 11.0
        println("Test method:$first")      // Здесь мы увидим 11
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val first = 99.0
            // Создаем экземпляр класса
            val tv = TestVariable()
            println("Main method:$first")     // Здесь мы увидим 99
            tv.testMethod(first)
            println("Main method:$first")     // И здесь мы снова увидим 99
        }
    }
}