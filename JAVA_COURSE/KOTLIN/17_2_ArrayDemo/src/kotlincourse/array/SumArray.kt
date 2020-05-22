package kotlincourse.array

/*object SumArray {
    @JvmStatic */
    fun main(args: Array<String>) {
        // Вы можете использовать инициализацию вот в таком виде
        // Перечисляете элементы массива чеерз запятую
        val sample = intArrayOf(12, 56, 7, 34, 89, 43, 23, 9)

        // До расчета суммы переменная для ее хранения содержит 0
        var summa = 0
        // Выполняем проход по всем элементам и прибавляем каждый к сумме
        for (i in sample.indices) {
            summa += sample[i]
        }
        println(sample.size.toString() + " TOTAL:" + summa)
    }
//}
