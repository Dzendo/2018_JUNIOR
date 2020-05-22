/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainsort;

/**
 *
 * @author LV
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
public class MainSort
{
    public static void main(String[] args) {
        System.out.println("Вариант сортировки через Comparator");
        List<MyClassCompare> listSort = new ArrayList<MyClassCompare>();
        listSort.add(new MyClassCompare("Василий"));
        listSort.add(new MyClassCompare("Павел"));
        listSort.add(new MyClassCompare("Андрей"));
        listSort.add(new MyClassCompare("Андрей"));
        listSort.add(new MyClassCompare("Петр"));
        listSort.add(new MyClassCompare("Анжелика"));
        // Сортировка через Comparable
        printCollection1("Без сортировки", listSort);
        Collections.sort(listSort);
        printCollection1("После сортировки", listSort);
 
        System.out.println("Вариант сортировки через Comparator");
        List<MyClass> list = new ArrayList<MyClass>();
        list.add(new MyClass("Василий"));
        list.add(new MyClass("Павел"));
        list.add(new MyClass("Андрей"));
        list.add(new MyClass("Андрей"));
        list.add(new MyClass("Петр"));
        list.add(new MyClass("Анжелика"));
        // Сортировка с классом Comparator
        printCollection2("Без сортировки", list);
        Collections.sort(list, new MyClassComparator());
        printCollection2("После сортировки", list);
    }
 
    private static void printCollection1(String title, List<MyClassCompare> list) {
        System.out.println(title);
        for (MyClassCompare mc : list) {
            System.out.println("Item:" + mc);
        }
        System.out.println();
    }
 
    private static void printCollection2(String title, List<MyClass> list) {
        System.out.println(title);
        for (MyClass mc : list) {
            System.out.println("Item:" + mc);
        }
        System.out.println();
    }
}
