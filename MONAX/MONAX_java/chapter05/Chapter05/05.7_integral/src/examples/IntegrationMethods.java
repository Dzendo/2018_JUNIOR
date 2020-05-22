/*
 * IntegrationMethods.java
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
public class IntegrationMethods {

    public static double integral(double a, double b, double n, Fnc fnc) {

        double s = 0;
        double h = (b - a) / n;
        for (int i = 0; i < n; i++) {
            s = s + fnc.f(a + i * h + h / 2) * h;
        }
        return s;
    }

    public static double badIntegral(double a, double b, double n, Fnc fnc) {
        double s = 0;
        double h = (b - a) / n;
        for (double x = a; x < b; x = x + h) {
            s = s + fnc.f(x+ h / 2) * h;
        }
        return s;
    }
    
}



