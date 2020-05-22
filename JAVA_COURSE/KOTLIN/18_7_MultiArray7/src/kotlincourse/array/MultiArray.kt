package kotlincourse.array

object MultiArray {
    @JvmStatic
    fun main(args: Array<String>) {
        // Объявим коснтанту для размера массива
        val SIZE = 26
        // Создаем двумерный массив
        val graph = Array(SIZE + 1) { CharArray(SIZE + 1) }

        // Цикл по первой размерности (первые квадратные скобки)
        for (i in 0 until SIZE + 1) {
            // Цикл по второй размерности (вторые квадратные скобки)
            for (j in 0 until SIZE + 1) {
                if (j == SIZE / 2 - i || j == SIZE / 2 + i ||
                        i - SIZE / 2 == j || i - SIZE / 2 == SIZE - j) {
                    // Это от ДО
                    graph[i][j] = '#'
                } else {
                    graph[i][j] = ' '
                }
            }
        }

        // Теперь выводим массив на экран
        // Цикл по первой размерности выводит строки
        for (i in 0..SIZE) {
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
