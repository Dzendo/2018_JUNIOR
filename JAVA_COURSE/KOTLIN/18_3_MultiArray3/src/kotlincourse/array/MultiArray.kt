package kotlincourse.array

object MultiArray {
    @JvmStatic
    fun main(args: Array<String>) {
        // Объявим конcтанту для размера массива
        val SIZE = 5
        // Создаем массив, в котором есть другие массивы
        // Причем массивы не создаются - они равны NULL
        val graph = arrayOfNulls<CharArray>(SIZE)

        // Цикл по элементам массива - все они пока равны NULL
        for (i in graph.indices) {
            // Проверяем равенство NULL - это правда
            println(graph[i] == null)
        }

        for (i in graph.indices) {
            // Создаем случайное число от 25 до 75 для указания размера массива
            val size = (Math.round(Math.random() * 50) + 25).toInt()
            // Теперь создаем массив нужного размера
            graph[i] = CharArray(size)
        }

        // Цикл по элементам массива - все они теперь проинициализированы
        for (i in graph.indices) {
            // Выводим размеры массивов, которые мы создали
            println(graph[i]?.size)

        }

    }
}
