/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdo;

/**
 *
 * @author LV
 */
public class Test1 {
    public int x;
    
   @Override
   protected void finalize() {
     // super.finalize();
    System.out.println(" Я умер " + x);
}
    
    
}
