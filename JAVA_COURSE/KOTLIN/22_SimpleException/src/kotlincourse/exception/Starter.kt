package kotlincourse.exception

object Starter {
    @JvmStatic
    fun main(args: Array<String>) {
        // создаем наш класс для генерации исключений
        val generator = Generator()

        // Данный блок будет обрабатывать исключение
        // и оно там действительно возникнет - мы же передали null
        try {
            val answer = generator.helloMessage("DO")
            println("Answer 1:$answer")
        } catch (ex: SimpleException) {
            // Здесь мы можем обработать объект-исключение,
            // получить некоторую информаицию
            println("Error code:" + ex.errorCode)
            println("Error message:" + ex.message)
        }

        // Данный блок будет обрабатывать исключение
        // но его не будет - мы передали корректный параметр
        try {
            val answer = generator.helloMessage(null)
            println("Answer 2:$answer")
        } catch (ex: SimpleException) {
            // Здесь мы можем обработать объект-исключение,
            // получить некоторую информаицию
            println("Error:" + ex.message)
            ex.printStackTrace()
        }

    }
}
