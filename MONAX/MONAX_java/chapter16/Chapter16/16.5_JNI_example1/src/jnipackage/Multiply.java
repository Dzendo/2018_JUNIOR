
package jnipackage;

/**
 *
 * @author Vadim Monakhov
 */
public class Multiply {

    static {
        System.out.println("Static initialization of the Multiply: Before loading");
        System.loadLibrary("CPP_MultiplyLibrary");
        System.out.println("Static initialization of the Multiply: After loading");
    } //Loading library on program start

    public static native double getJniProduct(double a, double b);
}
