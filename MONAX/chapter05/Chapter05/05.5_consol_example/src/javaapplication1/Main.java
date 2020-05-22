/*
 * Main.java
 * 
 * Created on 06.07.2007, 23:41:54
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package javaapplication1;

/**
 *
 * @author V.V.Monakhov
 */
public class Main {

    /** Creates a new instance of Main */
    public Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i=0,j=0;
        //j=++i;
        j=i++;
        System.out.println("j="+j+" i="+i);
    }

}
