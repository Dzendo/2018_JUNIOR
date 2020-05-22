package kotlincourse.array

/*object ForEachExample {
    @JvmStatic */
    fun main(args: Array<String>) {
        val sample = IntArray(5)

        println("До foreach")
        // выводим элементы в цикле foreach - их значение 0
        for (t in sample) {
            print(t)
          //  t = 99 kot дает ошибку
            println(" $t")
        }
        println("После foreach")
        // выводим элементы в цикле foreach - снова 0
        for (t in sample) {
            println(" $t")
        }

        // Для инициализации элементов foreach не подходит
        for (i in sample.indices) {
            sample[i] = 99

        }

        println("После foreach")
        // выводим элементы в цикле foreach - уже не 0
        for (t in sample) {
            println(t)
        }
    }
//}
