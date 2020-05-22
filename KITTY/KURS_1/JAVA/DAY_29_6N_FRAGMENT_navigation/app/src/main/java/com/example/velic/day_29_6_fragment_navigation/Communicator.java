package com.example.velic.day_29_6_fragment_navigation;
// Создадим новый класс через New | Java Class и в диалоговом окне для поля Kind выберем Interface.
// Также зададим ему имя Communicator.

public interface Communicator {
    public void count(String data);
}
// Активность должна реализовать интерфейс.
// Фрагмент с кнопкой может использовать объект интерфейса для отправки данных.
// Инициализируем его в новом методе onActivityCreated(), который ранее не использовали.
// Метод сработает, когда активность будет создана и готова к работе.