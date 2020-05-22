package edu.javacourse.queue;

public class QueueTest extends Object 
{
    public static void main(String[] arg) {
        ObjectQueue queue = new ObjectQueue();
            String s1;
           System.out.println("==Начинаю ставить в очередь =============");
        for(int i=0; i<100; i++) {
            // В данном случае мы складываем в очередь строки
            s1="дедушка " + (int) Math.round(Math.random() * 100) + " в тапочках";
            System.out.print("ставлю в очередь"+i+" вот это: " +s1);
            queue.push(s1);
            System.out.println("  Размер очереди стал:" + queue.size());
        }
               System.out.println("==Теперь перекличка по очереди =============");
        for(int i=0; i<queue.size(); i++) {
            String s = (String)queue.get(i);
            System.out.print("В очереди на месте "+i+ " стоит сейчас вот это : " +s);
            
            System.out.println(" сечас Размер очереди:" + queue.size());
        }
        System.out.println("=====Сечас будем принимать по очереди==========");
        while(queue.size() > 0) {
            // Мы делаем жесткое приведение типа, т.к. знаем, что там лежат строки
            String s = (String)queue.pull();
            System.out.print("принимаею из очереди вот это: "+s);
            System.out.println(" Теперь Размер очереди:" + queue.size());
        }
         System.out.println("==Очередь пустая я закончил пока-пока =============");
    }
}
