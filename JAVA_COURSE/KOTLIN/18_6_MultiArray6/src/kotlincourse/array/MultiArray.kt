package kotlincourse.array

object MultiArray {
    @JvmStatic
    fun main(args: Array<String>) {
        // Объявим коснтанту для размера массива
        val SIZE = 10
        // Создаем двумерный массив
        val graph = Array(SIZE + 1) { CharArray(SIZE + 1) }

        // Цикл по первой размерности (первые квадратные скобки)
        for (i in 0 until SIZE / 2 + 1) {
            // Цикл по второй размерности (вторые квадратные скобки)
            for (j in 0 until SIZE + 1) {
                if (i == SIZE / 2 || j == SIZE / 2 - i || j == SIZE / 2 + i) {
                    // Это от ДО
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
            for (j in 0..SIZE) {
                // Используем оператор print - без перехода на следующую строку
                print(graph[i][j])
            }
            // Переход на следующую строку
            println()
        }

    }
}
