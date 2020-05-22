/*
 * FncX2.java
 *
 * Created on April 9, 2007, 11:46 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package examples;

/**
 *
 * @author monakhov
 */
public class FncX2 extends Fnc{
    
    /** Creates a new instance of FncX2 */
    public FncX2() {
        super();
    }

    public double f(double x) {
       return x*x;
       //return Math.pow(x,2); //так не надо!!!
    }
}
