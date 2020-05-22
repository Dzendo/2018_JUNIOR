/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotlintestdo

import java.util.Date

/**
 *
 * @author LV
 */
object TestDO {


    /**
     * @param args the command line arguments
     */
    @JvmStatic
    fun main(args: Array<String>) {
        var a: Test1

        for (i in 0..9) {
            print(" Я Родился  $i ")
            a = Test1()
            a.x = i
            println(a.toString() + " " + a.hashCode() + " " + a.x)

        }
        a = Test1()
        a.x = 10
        println(a.toString() + " " + a.hashCode() + " " + a.x)

        var s = "1"
        println(Date())
        for (i in 0..99999) {
            s += "" + i
        }
        println(Date().toString() + " " + s.length)
        //System.out.println(a.x);
        val s1 = StringBuilder("1")
        println(System.currentTimeMillis())
        for (i in 0..99999) {
            s1.append("" + i)
        }
        println(System.currentTimeMillis().toString() + " " + s1.length)

    }
    // TODO code application logic hereprivate


}
