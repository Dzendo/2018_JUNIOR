/*
 * FncSin.java
 *
 * Created on April 9, 2007, 11:48 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package examples;

/**
 *
 * @author monakhov
 */
public class FncSin extends Fnc{
    
    /** Creates a new instance of FncSin */
    public FncSin() {
        super();
    }
    
    public double f(double x) {
       return Math.sin(x);
    }
    
}
