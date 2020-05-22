/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listexample;

/**
 *
 * @author LV
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
 
public class ListExample
{
    public static void main(String[] args) {
        // Создаем список для примера
        List<String> test = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            test.add("Строка " + i);
        }
        
        // Стандартный проход по всем элементам коллекции
        System.out.println();
        System.out.println("Печать через цикл foreach");
        for(String s : test) {
            System.out.println(s);
        }
        
        // Использование итератора
        System.out.println();
        System.out.println("Печать через итератор");
        for(Iterator<String> it = test.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
        
        // Используя ListIterator можем двигаться в обоих направлениях
        System.out.println();
        System.out.println("Печать через итератор списка от конца к началу");
        for( ListIterator<String> li = test.listIterator(test.size()); li.hasPrevious(); ) {
            String s = li.previous();
            System.out.println(s);
        }
        System.out.println("Печать через итератор списка от начала к концу");
        for( ListIterator<String> li = test.listIterator(); li.hasNext(); ) {
            String s = li.next();
            System.out.println(s);
        }
        
        // Обращение к элементу через индекс (позицию)
        System.out.println();
        System.out.println("Печать через индекс элемента");
        for(int i=0; i<test.size(); i++) {
            String s = test.get(i);
            System.out.println(s);
        }
    }
}