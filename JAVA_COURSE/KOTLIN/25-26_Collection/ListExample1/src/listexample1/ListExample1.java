/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listexample1;

/**
 *
 * @author LV
 */
import java.util.LinkedHashSet;
import java.util.Set;
 
public class ListExample1
{
    public static void main(String[] args) {
        Set<String> test = new LinkedHashSet<>();
        // Заполняем от 5 до 1
        for (int i = 5; i > 0; i--) {
            test.add("Строка " + i);
        }
        for (String s : test) {
            System.out.println(s);
        }
        System.out.println();
 
        // Заполняем (заменяем) от 1 до 5
        for (int i = 1; i < 6; i++) {
            test.add("Строка " + i);
        }
        for (String s : test) {
            System.out.println(s);
        }
        System.out.println();
    }
}
