package edu.javacourse.exception;

public class Generator
{
    // Данный метод описан с указанием того, что он способен кинуть 
    // исключение типа SimpleException
    public String helloMessage(String name) throws SimpleException
    {
        if (name == null) {
            // Мы должны сначала создать объект-исключение
            SimpleException se = new SimpleException(12, "Прилетело исключение");
            // Теперь мы можем "кинуть" это исключение - это другой способ выйти
            // из метода - отличный от варианта с return
            throw se;
            
            // Можно совместить создание и кидание - можете закомментировать
            // предыдущие строки и использовать нижеприведенную
            // throw new SimpleException(10, "Message is null");
        }
        return "  Hello, " + name;
    }
}
