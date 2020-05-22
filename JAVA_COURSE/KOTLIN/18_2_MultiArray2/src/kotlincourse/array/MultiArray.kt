package kotlincourse.array

object MultiArray {
    @JvmStatic
    fun main(args: Array<String>) {
        // Объявим коснтанту для размера массива
        val SIZE = 10
        // Создаем двумерный массив
        val graph = Array(SIZE) { CharArray(SIZE) }

        // Цикл по первой размерности (первые квадратные скобки)
        for (i in 0 until SIZE) {
            // Цикл по второй размерности (вторые квадратные скобки)
            for (j in 0 until SIZE) {
                if (i == 0 || i == SIZE - 1 || j == 0 || j == SIZE - 1) {
                    graph[i][j] = '#'
                } else {
                    graph[i][j] = ' '
                }
            }
        }

        // Теперь выводим массив на экран
        // Цикл по первой размерности выводит строки
        for (i in 0 until SIZE) {
            // Цикл по второй размерности выводит колонки - вывод одной строки
            for (j in 0 until SIZE) {
                // Используем оператор print - без перехода на следующую строку
                print(graph[i][j])
            }
            // Переход на следующую строку
            println()
        }

    }
}
