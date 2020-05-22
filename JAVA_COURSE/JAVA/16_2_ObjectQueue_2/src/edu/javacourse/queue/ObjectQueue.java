package edu.javacourse.queue;

public class ObjectQueue
{   /// FIFO-LIFO
    // Указатель на первый элемент
    private ObjectBox head = null;
    // Указатель на последний элемент
    private ObjectBox tail = null;
    private ObjectBox temp = null;
    // Поле для хранения размера очереди
    private int size = 0;

    public void push(Object obj,boolean TAIL) {
        // FIFO true ставим в начало false в конец
        // Сразу создаем вспомогательный объект и помещаем новый элемент в него
        ObjectBox ob = new ObjectBox();
        ob.setObject(obj);
        size++;
        if (tail == null) {
             // Если очередь пустая - в ней еще нет элементов
            // Теперь наша голова и хвост указывает на наш первый элемент
            tail = ob;
            head = ob;
            return;
        }
            
            
        if (TAIL) {
            // Ставим в голову
            // Если это не первый элемент, то надо, чтобы последний элемент в очереди
            // указывал на вновь прибывший элемент
                                
            temp = head;
            head.setPrev(ob);
            head = ob;
            head.setNext(temp);
            
               
        } else {
                // Ставим в хвост
                // Если это не первый элемент, то надо, чтобы Первый элемент в очереди
                // указывал на вновь прибывший элемент

                temp = tail;
                tail.setNext(ob);
                tail = ob;
                tail.setPrev(temp);

              }
             
            
        // И в любом случае нам надо наш "хвост" переместить на новый элемент
        // Если это первый элемент, то "голова" и "хвост" будут указывать на один и тот же элемент
        
 
        // Увеличиваем размер нашей очереди
        
    }
    public Object pull(boolean HEAD) {
        // FIFO true берем из начало false из конеца
        Object obj;
        // Если у нас нет элементов, то возвращаем null
        if (size == 0) {
            return null;
        }
     
        // Получаем наш объект из вспомогательного класса из "головы"
        if (HEAD) {
            obj = head.getObject();
        // Перемещаем "голову" на следующий элемент
        head = head.getNext();
        // Если это был единственный элемент, то head станет равен null
        // и тогда tail (хвост) тоже дожен указать на null.
        
        } else{
            obj = tail.getObject();
        // Перемещаем "голову" на следующий элемент
        tail = tail.getPrev();
        // Если это был единственный элемент, то head станет равен null
        // и тогда tail (хвост) тоже дожен указать на null.
        
        }
        
        size--;
        
        if (head == null | tail == null) {
            head = null;
            tail = null;
        }
        // Уменьшаем размер очереди
        
        // Возвращаем значение
        return obj;
    
    }

    public Object get(int index) {
        // Если нет элементов или индекс больше размера или индекс меньше 0
        if(size == 0 || index >= size || index < 0) {
            return null;
        }
        // Устанавлваем указатель, который будем перемещать на "голову"
        ObjectBox current;
        int pos;
        
        if (index<=size/2){
        current= head;
        // В этом случае позиция равну 0
        pos = 0;
        // Пока позиция не достигла нужного индекса
            while(pos < index) {
                // Перемещаемся на следующий элемент
                current = current.getNext();
                // И увеличиваем позицию
                pos++;
            }
        } else {
        current = tail;
        // В этом случае позиция равну 0
        pos = size-1;
        // Пока позиция не достигла нужного индекса
            while(pos > index) {
                // Перемещаемся на следующий элемент
                current = current.getPrev();
                // И увеличиваем позицию
                pos--;
            }
        }
        // Мы дошли до нужной позиции и теперь можем вернуть элемент
        Object obj = current.getObject();
        return obj;
    }
    
    public int size() {
        return size;
    }

// Наш вспомогательный класс будет закрыт от посторонних глаз
    private class ObjectBox
    {
        // Поле для хранения объекта
        private Object object;
        // Поле для указания на следующий элемент в цепочке.
        // Если оно равно NULL - значит это последний элемент
        private ObjectBox next;
        private ObjectBox prev;

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public ObjectBox getNext() {
            return next;
        }
        public ObjectBox getPrev() {
           return prev;

        }

        public void setNext(ObjectBox next) {
            this.next = next;
        }
        public void setPrev(ObjectBox prev) {
            this.prev = prev;
        }
    } // Конец class ObjectBox
}   // Конец class ObjectQueue
