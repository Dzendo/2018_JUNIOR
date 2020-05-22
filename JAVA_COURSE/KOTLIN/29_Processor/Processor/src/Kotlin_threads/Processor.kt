/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
run:
270890338197, Time 1:278860
270889843406, Time 2:65205
СБОРКА УСПЕШНО ЗАВЕРШЕНА (общее время: 5 минуты 44 секунды)

 * and open the template in the editor.
 */
package Kotlin_threads

import java.math.BigInteger
import java.security.SecureRandom
import java.util.ArrayList
import java.util.concurrent.*

/**
 *
 * @author LV
 */
class Processor {

    fun process(): Long {
        var summa: Long = 0L

        val random = SecureRandom()
        for (i in 0 until Processor.TASK_COUNT) {
            val g = BigInteger(500, random).toString(32)
            for (c in g.toCharArray()) {
                summa += c.toLong()
            }
        }
        return summa
    }

    companion object {
        //public class Threads {
        val STR_COUNT = 10000
        val TASK_COUNT = 3000
        /**
         * @param args the command line arguments
         */
        @JvmStatic
        fun main(args: Array<String>) {
            // TODO code application logic here
            run {
                val bt = BigTaskOneThread()
                val d1 = System.currentTimeMillis()
                val result = bt.startTask()
                val d2 = System.currentTimeMillis()
                println(result.toString() + ", Time 1:" + (d2 - d1))
            }
            run {
                val bt = BigTaskManyThreads()
                val d1 = System.currentTimeMillis()
                val result = bt.startTask()
                val d2 = System.currentTimeMillis()
                println(result.toString() + ", Time 2:" + (d2 - d1))
            }
        }
    }
}

internal class BigTaskOneThread {

    fun startTask(): Long {
        var summa: Long = 0L
        for (i in 0 until Processor.STR_COUNT) {
            val p = Processor()
            summa += p.process()
        }
        return summa
    }

}

internal class BigTaskManyThreads {

    fun startTask(): Long {
        val ap = Runtime.getRuntime().availableProcessors()
        val es = Executors.newFixedThreadPool(ap)

        var summa: Long = 0L
        try {
            val threads = ArrayList<MyCallable>()
            for (i in 0 until Processor.STR_COUNT) {
                threads.add(MyCallable())
            }
            val result = es.invokeAll(threads)

            for (f in result) {
                summa += f.get()
            }
            es.shutdown()
        } catch (ex: InterruptedException) {
            ex.printStackTrace(System.out)
        } catch (ex: ExecutionException) {
            ex.printStackTrace(System.out)
        }

        return summa
    }
}

internal class MyCallable : Callable<Long> {

    @Throws(Exception::class)
    override fun call(): Long? {
        val p = Processor()
        return p.process()
    }
} 
       
