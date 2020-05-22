package edu.javacourse.robot;

public class ObjectQueue
{
    private boolean PUSH = false;  // кладем true - в начало, false - в  конец
    private boolean PULL = true;   // берем  true - с начала, false - с  конца

   /// FIFO: false-true или true-false  LIFO: true-true или false-false    
    // Указатель на первый элемент
    private ObjectBox head = null;
    // Указатель на последний элемент
    private ObjectBox tail = null;
     // Поле для хранения размера очереди
    private int size = 0;
     // 
    public void FIFO_LIFO(boolean PUSH, boolean PULL){
        this.PUSH=PUSH;
        this.PULL=PULL;   
    }

    public void push(Object obj) {
        // FIFO true ставим в начало false в конец
        // Сразу создаем вспомогательный объект и помещаем новый элемент в него
        ObjectBox ob = new ObjectBox();
        ob.setObject(obj);
        // Увеличиваем размер нашей очереди
        size++;
        if (tail == null) {
             // Если очередь пустая - в ней еще нет элементов
            // Теперь наша голова и хвост указывает на наш первый элемент
            tail = ob;
            head = ob;
            return;
        }   
            
        if (PUSH) {
            // Ставим в голову
            // Если это не первый элемент, то надо, чтобы последний 
            // элемент в очереди указывал на вновь прибывший элемент
                             
                head.setPrev(ob);
                ob.setNext(head);
                head = ob; 
               
        } else {
                // Ставим в хвост
                // Если это не первый элемент, то надо, чтобы 
                // Первый элемент в очереди указывал на вновь прибывший элемент

                tail.setNext(ob);
                ob.setPrev(tail);
                tail = ob;
                
              }
             
            
        
    }
    
    public Object pull() {
        // PULL true берем из начала, false - из конца
        Object obj;
        // Если у нас нет элементов, то возвращаем null
        if (size == 0) {
            return null;
        }
     
        // Получаем наш объект из вспомогательного класса из "головы"
        if (PULL) {
            obj = head.getObject();
            // Перемещаем "голову" на следующий элемент
            head = head.getNext();
            if (size>1) head.setPrev(null);
        } else{
            obj = tail.getObject();
            // Перемещаем "хвост" на следующий элемент
            tail = tail.getPrev();
            if (size>1) tail.setNext(null);
        }
         // Уменьшаем размер очереди
        size--;
         // Если это был единственный элемент, то head станет равен null
        // и тогда tail (хвост) тоже дожен указать на null.
        // Если это был единственный элемент, то head станет равен null
        // и тогда tail (хвост) тоже дожен указать на null.
        if (head == null | tail == null) {  // size==0
            head = null;
            tail = null;
        }
               
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
