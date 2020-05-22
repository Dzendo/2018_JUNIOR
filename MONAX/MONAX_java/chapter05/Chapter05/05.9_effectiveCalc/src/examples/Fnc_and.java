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
public class Fnc_and extends Fnc{
    
    /** Creates a new instance of FncSin */
    public Fnc_and() {
        super();
    }
    
    public long f(long i) {
       return i & 0xAF;
    }
    
}
