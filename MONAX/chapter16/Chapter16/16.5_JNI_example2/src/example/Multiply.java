/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

/**
 *
 * @author User
 */
public class Multiply {

    static {
        System.loadLibrary("CPP_MultiplyLibrary2");
    }

    public static native double getProduct(double A, double B);

    public static native double[][] getProduct(double[][] A, double[][] B);
}
