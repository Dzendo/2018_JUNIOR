package edu.javacourse.queue;

public class QueueTest extends Object 
{   //// LIFO
    public static void main(String[] arg) {
        final boolean HEAD  =true;   // кладем true - в начало, false - в  конец
        final boolean TAIL  =false;  // берем  true - с начала, false - с  конца
        ObjectQueue queue = new ObjectQueue();
        queue.FIFO_LIFO(TAIL, HEAD);
            String s1;
            String s;
           System.out.println("==Начинаю ставить в очередь =============");
        for(int i=0; i<19; i++) {
            // В данном случае мы складываем в очередь строки
            s1="дедушка " + i;
            // s1="дедушка " + (int) Math.round(Math.random() * 100) + " в тапочках";
            System.out.print("ставлю в очередь"+i+" вот это: " +s1);
            queue.push(s1);
            System.out.println("  Размер очереди стал:" + queue.size());
        }
               System.out.println("==Теперь перекличка по очереди =============");
        for(int i=0; i<queue.size(); i++) {
           s = (String)queue.get(i);
            System.out.print("В очереди на месте "+i+ " стоит сейчас вот это : " +s);
            
            System.out.println(" сечас Размер очереди:" + queue.size());
        }
          // проверка по номерам
            s = (String)queue.get(queue.size()/3);
            System.out.println("В очереди на месте "+queue.size()/3+ " стоит сейчас вот это : " +s);
            s = (String)queue.get(queue.size()/2);
            System.out.println("В очереди на месте "+queue.size()/2+ " стоит сейчас вот это : " +s);
            s = (String)queue.get(queue.size()/3*2);
            System.out.println("В очереди на месте "+queue.size()/3*2+ " стоит сейчас вот это : " +s);
        
        System.out.println("=====Сечас будем принимать по очереди==========");
        while(queue.size() > 0) {
            // Мы делаем жесткое приведение типа, т.к. знаем, что там лежат строки
            s = (String)queue.pull();
            System.out.print("принимаю из очереди вот это: "+s);
            System.out.println(" Теперь Размер очереди:" + queue.size());
        }
         System.out.println("==Очередь пустая я закончил пока-пока =============");
    }
}
