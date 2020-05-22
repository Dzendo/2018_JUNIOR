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
public class Fnc_or extends Fnc{
    
    /** Creates a new instance of FncSqrt */
    public Fnc_or() {
        super();
    }
    
    public long f(long i) {
       return i | 0xAF;
    }
}
