package kotlincourse.array

/*
 * Пример сортировки массива методом пузырька
 */
/*object SortArray {
    @JvmStatic */
    fun main(args: Array<String>) {
        val sample = intArrayOf(12, 56, 7, 34, 89, 43, 23, 9)

        // выставляем признак "обмена" переменных в true, чтобы начать цикл
        var changed = true

        // цикл длится до тех пор, пока при проверке массива ни одного обмена не произошло
        while (changed) {
            // Надеемся, что обмена данных не будет
            changed = false
            // Проходим по всему массиву
            for (i in 0 until sample.size - 1) {
                // Если впереди стоящее число больше, чем следующее - меняем
                // их местами и выставляем признак, что был обмен
                if (sample[i] > sample[i + 1]) {
                    // Производим обмен с использованием дополнительной переменной
                    val tmp = sample[i]
                    sample[i] = sample[i + 1]
                    sample[i + 1] = tmp
                    // Выставляем признак обмена в true
                    changed = true
                }
            }
        }
        // Выводим отсортрованный массив
        for (i in sample.indices) {
            println(sample[i])
        }
    }
// }
