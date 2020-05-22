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
import java.util.Comparator;
 
public class MyClassComparator implements Comparator
{
    @Override  // Это добавил ДО
    public int compare(Object o1, Object o2) {
        return -o1.toString().compareTo(o2.toString());
    }
}
