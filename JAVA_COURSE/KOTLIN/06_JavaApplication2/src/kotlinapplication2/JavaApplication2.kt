/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotlinapplication2

/**
 *
 * @author LV
 */
object JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    @JvmStatic
    fun main(args: Array<String>) {
        // TODO code application logic here
        println("Привет! javaapplication2")
        try {
            System.`in`.read()
        } catch (e: Exception) {
        }

    }

}
