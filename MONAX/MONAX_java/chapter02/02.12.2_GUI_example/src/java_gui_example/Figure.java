/*
 * Figure.java
 * 
 * Created on 03.07.2007, 14:13:23
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package java_gui_example;

/**
 *
 * @author В.В.Монахов
 */
public class Figure {

    /**
     *
     */
    public Figure() {
    }
    
    private int x=0;
    private int y=0;

    /**
     *
     */
    public int a;

    /**
     *
     * @param x
     * @return
     */
    public int f1(int x) {
return 2 * x;
}

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public float f2(float x,float y) {
return x+y;
}
}
