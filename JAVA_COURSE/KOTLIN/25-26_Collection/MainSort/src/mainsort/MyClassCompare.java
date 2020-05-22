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
public class MyClassCompare implements Comparable<MyClassCompare>
{
    private final String name;
 
    public MyClassCompare(String name) {
        this.name = name;
    }
 
    // этот метод как раз и сравнивает текущий объект с другим, 
    // который передается в качестве аргумента
    @Override  // Это добавил ДО
    public int compareTo(MyClassCompare o) {
        return -name.compareTo(o.name);
    }
 
    @Override 
    public String toString() {
        return name;
    }
}
