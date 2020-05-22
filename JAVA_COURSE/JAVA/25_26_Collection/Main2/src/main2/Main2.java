/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main2;

/**
 *
 * @author LV
 */
import java.util.ArrayList;
import java.util.List;
 
public class Main2
{
    public static void main(String[] args) {
        // List<MyClass1> list1 = new ArrayList<>();
        List<BasicClass> list1 = new ArrayList<>();
        list1.add(new MyClass1("Василий 1"));
        list1.add(new MyClass1("Павел 1"));
        list1.add(new MyClass1("Андрей 1"));
        list1.add(new MyClass1("Петр 1"));
        list1.add(new MyClass1("Анжелика 1"));
        printCollection("Коллеция 1", list1);
 
        List<MyClass2> list2 = new ArrayList<>();
        list2.add(new MyClass2("Василий 2"));
        list2.add(new MyClass2("Павел 2"));
        list2.add(new MyClass2("Андрей 2"));
        list2.add(new MyClass2("Петр 2"));
        list2.add(new MyClass2("Анжелика 2"));
        printCollection("Коллекция 2", list2);
    }
 
    //private static void printCollection(String title, List<? extends BasicClass> list) { // см выше обявл class1
    private static void printCollection(String title, List<? super MyClass2> list) {
        System.out.println(title);
        for (Object mc : list) {
            // Т.к. классы - наследники BasicClass, то обе коллекции 
            // содержат объекты этого типа.
            BasicClass bc = (BasicClass)mc;
            System.out.println("Item:" + bc.getName());
        }
        System.out.println();
    }
}
