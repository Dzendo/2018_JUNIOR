/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdo;

import java.util.Date;

/**
 *
 * @author LV
 */
public class TestDO {
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Test1 a;   
       
  for (int i=0 ; i<10 ; i++) {
       System.out.print(" Я Родился  " + i +" ");
       a = new Test1();
       a.x=i;
       System.out.println(a.toString()+" "+a.hashCode() + " " + a.x);
      
  }    
   a = new Test1();
       a.x=10;
  System.out.println(a.toString()+" "+a.hashCode() + " " + a.x);
 
  String s = "1";
        System.out.println(new Date());
        for(int i=0; i<100000; i++) {
            s += "" + i;
        }
        System.out.println(new Date()+ " " + s.length());
        //System.out.println(a.x);
        StringBuilder s1 = new StringBuilder("1");
        System.out.println(System.currentTimeMillis());
        for(int i=0; i<100000; i++) {
            s1.append("" + i);
        }
        System.out.println(System.currentTimeMillis()+ " " + s1.length());
        
    }
        // TODO code application logic hereprivate
    
    
}
