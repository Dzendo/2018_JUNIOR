package kotlincourse.queue

class ObjectQueue {
    // Указатель на первый элемент
    private var head: ObjectBox? = null
    // Указатель на последний элемент
    private var tail: ObjectBox? = null
    private var temp: ObjectBox? = null
    // Поле для хранения размера очереди
    private var size = 0

    fun push(obj: Any) {
        // Сразу создаем вспомогательный объект и помещаем новый элемент в него
        val ob = ObjectBox()
        ob.`object` = obj
        // Если очередь пустая - в ней еще нет элементов
        if (head == null) {
            // Теперь наша голова указывает на наш первый элемент
            head = ob
            tail = ob
        } else {
            // Если это не первый элемент, то надо, чтобы последний элемент в очереди
            // указывал на вновь прибывший элемент

            temp = tail
            tail!!.next = ob
            tail = ob
            tail!!.prev = temp

        }
        // И в любом случае нам надо наш "хвост" переместить на новый элемент
        // Если это первый элемент, то "голова" и "хвост" будут указывать на один и тот же элемент


        // Увеличиваем размер нашей очереди
        size++
    }

    fun pull(): Any? {
        // Если у нас нет элементов, то возвращаем null
        if (size == 0) {
            return null
        }
        // Получаем наш объект из вспомогательного класса из "головы"
        val obj = head!!.`object`
        // Перемещаем "голову" на следующий элемент
        head = head!!.next
        // Если это был единственный элемент, то head станет равен null
        // и тогда tail (хвост) тоже дожен указать на null.
        if (head == null) {
            tail = null
        }
        // Уменьшаем размер очереди
        size--
        // Возвращаем значение
        return obj
    }

    operator fun get(index: Int): Any? {
        // Если нет элементов или индекс больше размера или индекс меньше 0
        if (size == 0 || index >= size || index < 0) {
            return null
        }
        // Устанавлваем указатель, который будем перемещать на "голову"
        var current: ObjectBox?
        var pos: Int

        if (index <= size / 2) {
            current = head
            // В этом случае позиция равну 0
            pos = 0
            // Пока позиция не достигла нужного индекса
            while (pos < index) {
                // Перемещаемся на следующий элемент
                current = current!!.next
                // И увеличиваем позицию
                pos++
            }
        } else {
            current = tail
            // В этом случае позиция равну 0
            pos = size - 1
            // Пока позиция не достигла нужного индекса
            while (pos > index) {
                // Перемещаемся на следующий элемент
                current = current!!.prev
                // И увеличиваем позицию
                pos--
            }
        }
        // Мы дошли до нужной позиции и теперь можем вернуть элемент
        return current!!.`object`
    }

    fun size(): Int {
        return size
    }

    // Наш вспомогательный класс будет закрыт от посторонних глаз
    private inner class ObjectBox {
        // Поле для хранения объекта
        var `object`: Any? = null
        // Поле для указания на следующий элемент в цепочке.
        // Если оно равно NULL - значит это последний элемент
        var next: ObjectBox? = null
        var prev: ObjectBox? = null
    } // Конец class ObjectBox
}   // Конец class ObjectQueue
