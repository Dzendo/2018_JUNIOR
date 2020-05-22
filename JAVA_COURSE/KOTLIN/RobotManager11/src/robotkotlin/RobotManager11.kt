/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotkotlin

/**
 *
 * @author LV
 */
object RobotManager11 {
    @JvmStatic
    fun main(args: Array<String>) {
        val robot1 = Robot("Test Robot 1")
        val robot2 = Robot("Test Robot 2")
        println(robot1.toString())
        println(robot2.toString())
    }
}