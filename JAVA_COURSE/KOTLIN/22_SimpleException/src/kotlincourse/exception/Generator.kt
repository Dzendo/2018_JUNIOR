package kotlincourse.exception

class Generator {
    // Данный метод описан с указанием того, что он способен кинуть
    // исключение типа SimpleException
    @Throws(SimpleException::class)
    fun helloMessage(name: String?): String {
        if (name == null) {
            // Мы должны сначала создать объект-исключение
            val se = SimpleException(12, "Прилетело исключение")
            // Теперь мы можем "кинуть" это исключение - это другой способ выйти
            // из метода - отличный от варианта с return
            throw se

            // Можно совместить создание и кидание - можете закомментировать
            // предыдущие строки и использовать нижеприведенную
            // throw new SimpleException(10, "Message is null");
        }
        return "  Hello, $name"
    }
}
