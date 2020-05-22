package edu.javacourse.exception;

public class SimpleException extends Exception
{
    // Это наше поле для хранения информации, присущей данному
    // классу-исключению. Поле немножко надуманное, но здесь может быть
    // и достаточно важная информация
    private int errorCode;

    // переопределяем конструктор
    public SimpleException(String message)
    {
        this(0, message);
    }

    // Создаем свой конструктор
    public SimpleException(int errorCode, String message)
    {
        // Вызываем конструктор предка
        super(message);
        // Добравляем инициализацию своего поля
        this.errorCode = errorCode;
    }

    // Метод для получения кода ошибки
    public int getErrorCode()
    {
        return errorCode;
    }
}
