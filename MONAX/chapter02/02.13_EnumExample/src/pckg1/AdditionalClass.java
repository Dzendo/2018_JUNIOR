/*
 * AdditionalClass.java
 *
 * Created on 4 июля 2007 г., 14:04
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * ������ ����������������� ����������� ��� ������ pckg1
 */
package pckg1;

/**
 * ����� <code>AdditionalClass</code> ������������ ��� ����������� 
 * ������������� ���������������� ������������
 * @see AdditionalClass#x
 * @see AdditionalClass#y
 * @author User
 */
public class AdditionalClass {
    /** ������������� ���� ������  */
    public int x=1,y=1;    
    /** Creates a new instance of AdditionalClass */
    public AdditionalClass() {
    }
    
    int i=1;

    
    double mult1(double x, final double y){
        //int i=5;
        for(int i=10;i<100;i++){
              x++;
        }
        return x*y;
    }
    
      double mult2(double x, final double y){
        int mult1=5;
        for(int i=10;i<100;i++){
            x++;
        }
        return mult1(x,y);
    }
    
    
}
