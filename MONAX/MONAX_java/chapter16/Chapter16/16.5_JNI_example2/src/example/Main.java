/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

/**
 * @author User
 */
public class Main {

    public static String matrixToString(double[][] M) {
        String s = "";
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                s = s + M[i][j] + "\t";
            }
            s = s + "\n";
        }
        return s;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Start of the method main.");
        System.out.println("Product of 2.5 and 4 is: " + 
                                     Multiply.getProduct(2.5, 4) + "\n");

        double A[][] = {{1, 2, 3}, {4, 5, 6}};
        double B[][] = {{1, 2}, {3, 4}, {5, 6}};
        double C[][] = Multiply.getProduct(A, B);
        System.out.println("Matrix A: \n" + matrixToString(A));
        System.out.println("Matrix B: \n" + matrixToString(B));
        if (C != null) {
            System.out.println("Product of A and B is:\n" +
                                           matrixToString(C));
        } else {
            System.out.println("Cannot multiply A and B!\n");
        }
    }

    }

