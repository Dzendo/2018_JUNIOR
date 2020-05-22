// Волшебное слово — synchronized
package kotincounter

/**
 *
 * @author LV
 */
object CounterTester {
    @Throws(InterruptedException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val counter = Counter()
        for (i in 0..199) {
            val ct = CounterThread(counter)
            ct.start()
        }
        Thread.sleep(1000)

        println("Counter:" + counter.counter)
    }
}

internal class Counter {
    var counter = 0L
        private set

    //public synchronized void increaseCounter() { //Counter:200000
    fun increaseCounter() {   // Counter:198222 Counter:198795
        synchronized(this) {
            // или так Counter:200000
            counter++
        }
    }  // несинхронизированное обращение теряет суммы см выше !!!!
}

internal class CounterThread(private val counter: Counter) : Thread() {

    override fun run() {
        for (i in 0..999) {
            counter.increaseCounter()
        }
    }
}