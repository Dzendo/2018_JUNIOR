package kotlincourse.array

object ArrayDemo_kt {
    @JvmStatic
    fun main(args: Array<String>) {
        val demo = IntArray(10)
        for (i in demo.indices) {
            // Переменная доступна и там значение 0
            println(demo[i])
            // Присваиваем ей другое значение
            demo[i] = 10 * (i + 1)
        }
        for (i in demo.indices) {
            println(demo[i])
        }
    }
}
