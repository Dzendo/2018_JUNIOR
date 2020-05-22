package kotlincourse.queue

class QueueTest : Any() {
    companion object {
        @JvmStatic
        fun main(arg: Array<String>) {
            val queue = ObjectQueue()
            var s1: String
            println("==Начинаю ставить в очередь =============")
            for (i in 0..99) {
                // В данном случае мы складываем в очередь строки
                s1 = "дедушка " + Math.round(Math.random() * 100).toInt() + " в тапочках"
                print("ставлю в очередь$i вот это: $s1")
                queue.push(s1)
                println("  Размер очереди стал:" + queue.size())
            }
            println("==Теперь перекличка по очереди =============")
            for (i in 0 until queue.size()) {
                val s = queue.get(i) as String
                print("В очереди на месте $i стоит сейчас вот это : $s")

                println(" сечас Размер очереди:" + queue.size())
            }
            println("=====Сечас будем принимать по очереди==========")
            while (queue.size() > 0) {
                // Мы делаем жесткое приведение типа, т.к. знаем, что там лежат строки
                val s = queue.pull() as String
                print("принимаею из очереди вот это: $s")
                println(" Теперь Размер очереди:" + queue.size())
            }
            println("==Очередь пустая я закончил пока-пока =============")
        }
    }
}
