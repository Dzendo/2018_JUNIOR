/*
 * FncSqrt.java
 *
 * Created on April 9, 2007, 11:50 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package examples;

/**
 *
 * @author monakhov
 */
public class FncSqrt extends Fnc{
    
    /** Creates a new instance of FncSqrt */
    public FncSqrt() {
        super();
    }
    public double f(double x) {
       return Math.sqrt(x);
       //return Math.pow(x,0.5); //так не надо!!!
    }    
}
