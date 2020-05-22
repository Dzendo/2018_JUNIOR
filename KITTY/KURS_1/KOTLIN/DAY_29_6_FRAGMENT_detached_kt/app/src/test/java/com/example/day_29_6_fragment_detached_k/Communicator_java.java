package com.example.day_29_6_fragment_detached_k;
// Создадим новый класс через New | Java Class и в диалоговом окне для поля Kind выберем Interface.
// Также зададим ему имя Communicator.

public interface Communicator_java {
    public void count(String data);
}
// Активность должна реализовать интерфейс.
// Фрагмент с кнопкой может использовать объект интерфейса для отправки данных.
// Инициализируем его в новом методе onActivityCreated(), который ранее не использовали.
// Метод сработает, когда активность будет создана и готова к работе.