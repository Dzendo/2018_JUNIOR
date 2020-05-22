/*
 * MiddleTriangles.java
 *
 * Created on April 9, 2007, 11:22 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package examples;

/**
 *
 * @author monakhov
 */
public class MiddleTriangles {
    
    
    
    public static double optimisedIntegral(double a,double b,double n,Fnc fnc) {
        
        double r=0, h=(b-a)/n, a1=a+h/2;
        for(int i=0;i<n;i++)
            r+=fnc.f(a1+i*h);
        return r*h;
    }
    
    public static double integral(double a,double b, double n, Fnc fnc) {
        
        double r=0, h=(b-a)/n;
        for(int i=0;i<n;i++)
            r=r+fnc.f(a+i*h+h/2)*h;
        return r;
    }
    
    
    public static double slowIntegral(double a,double b, double n, Fnc fnc) {
        
        double r=0;
        for(int i=0;i<n;i++)
            r=r+fnc.f(a+i*(b-a)/n+(b-a)/n/2) * (b-a)/n;
        return r;
    }
    
    
    public static double inlineIntegralX(double a,double b, double n) {
        
       double r=0, h=(b-a)/n;
        for(int i=0;i<n;i++)
            r=r+(a+i*h+h/2)*h;
        return r;
    } 
        
/*         double r=0;
        for(int i=0;i<n;i++)
            r=r+(a+i*(b-a)/n+(b-a)/n/2) * (b-a)/n;
        return r;
    }
 */
}



