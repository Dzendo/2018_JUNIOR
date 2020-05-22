/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericmethod;

/**
 *
 * @author LV
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
public class GenericMethod {
 
    // Объявление метода, который типизируется
    public <T> T addAndReturn(T element, Collection<T> collection) {
        collection.add(element);
        return element;
    }
 
    public static void main(String[] arg) {
        GenericMethod gm = new GenericMethod();
        
        // Вызываем метод для элемента типа String
        String stringElement = "stringElement";
        List<String> stringList = new ArrayList<>();
        String theElement1 = gm.addAndReturn(stringElement, stringList);
        System.out.println("Element1:" + theElement1);
        stringElement = "stringElement LV";
        theElement1 = gm.addAndReturn(stringElement, stringList);
        System.out.println("Element1:" + theElement1);
        stringElement = "stringElement DO";
        theElement1 = gm.addAndReturn(stringElement, stringList);
        System.out.println("Element1:" + theElement1);
         System.out.println("Element:" + stringList);
 
        // Вызываем метод для элемента типа Integer
        Integer integerElement = 123;
        List<Integer> integerList = new ArrayList<>();
        Integer theElement2 = gm.addAndReturn(integerElement, integerList);
        System.out.println("Element2:" + theElement2);
        integerElement = 222;
        theElement2 = gm.addAndReturn(integerElement, integerList);
        System.out.println("Element2:" + theElement2);
        integerElement = 999;
        theElement2 = gm.addAndReturn(integerElement, integerList);
        System.out.println("Element2:" + theElement2);
        System.out.println("Element:" + integerList);
    }
}
