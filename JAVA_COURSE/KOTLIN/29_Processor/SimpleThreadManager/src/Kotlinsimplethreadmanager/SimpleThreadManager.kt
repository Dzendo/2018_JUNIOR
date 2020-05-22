/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kotlinsimplethreadmanager

/**
 *
 * @author LV
 */
object SimpleThreadManager {
    @JvmStatic
    fun main(arg: Array<String>) {
        for (i in 0..999) {
            val first = SimpleThread()
            first.start()
        }
    }
}

internal class SimpleThread : Thread() {
    override fun run() {
        try {
            val pause = Math.round(Math.random() * 7000)
            Thread.sleep(pause)
            println("Simple Thread - pause=$pause")
        } catch (i_ex: InterruptedException) {

        }

    }
}