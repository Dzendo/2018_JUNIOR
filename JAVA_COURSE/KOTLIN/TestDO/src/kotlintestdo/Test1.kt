/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotlintestdo

/**
 *
 * @author LV
 */
class Test1 {
    var x: Int = 0

    protected fun finalize() {
        // super.finalize();
        println(" Я умер $x")
    }


}
