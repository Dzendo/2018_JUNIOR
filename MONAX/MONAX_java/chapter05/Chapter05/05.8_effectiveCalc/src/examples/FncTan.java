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
public class FncTan extends Fnc{
    
    /** Creates a new instance of FncSin */
    public FncTan() {
        super();
    }
    
    public double f(double x) {
       return Math.tan(x);
    }
    
}
