package kotlincourse.queue

class QueueTest : Any() {   //// LIFO
    companion object {
        @JvmStatic
        fun main(arg: Array<String>) {
            val HEAD = true   // кладем true - в начало, false - в  конец
            val TAIL = false  // берем  true - с начала, false - с  конца
            val queue = ObjectQueue()
            queue.FIFO_LIFO(TAIL, HEAD)
            var s1: String
            var s: String
            println("==Начинаю ставить в очередь =============")
            for (i in 0..18) {
                // В данном случае мы складываем в очередь строки
                s1 = "дедушка $i"
                // s1="дедушка " + (int) Math.round(Math.random() * 100) + " в тапочках";
                print("ставлю в очередь$i вот это: $s1")
                queue.push(s1)
                println("  Размер очереди стал:" + queue.size())
            }
            println("==Теперь перекличка по очереди =============")
            for (i in 0 until queue.size()) {
                s = queue.get(i) as String
                print("В очереди на месте $i стоит сейчас вот это : $s")

                println(" сечас Размер очереди:" + queue.size())
            }
            // проверка по номерам
            s = queue.get(queue.size() / 3) as String
            println("В очереди на месте " + queue.size() / 3 + " стоит сейчас вот это : " + s)
            s = queue.get(queue.size() / 2) as String
            println("В очереди на месте " + queue.size() / 2 + " стоит сейчас вот это : " + s)
            s = queue.get(queue.size() / 3 * 2) as String
            println("В очереди на месте " + queue.size() / 3 * 2 + " стоит сейчас вот это : " + s)

            println("=====Сечас будем принимать по очереди==========")
            while (queue.size() > 0) {
                // Мы делаем жесткое приведение типа, т.к. знаем, что там лежат строки
                s = queue.pull() as String
                print("принимаю из очереди вот это: $s")
                println(" Теперь Размер очереди:" + queue.size())
            }
            println("==Очередь пустая я закончил пока-пока =============")
        }
    }
}
