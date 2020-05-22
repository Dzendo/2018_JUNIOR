/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LV
 */
import static java.lang.Math.*;
	import java.util.Scanner; 
	public class СортировкаМассива {
	protected static int[] массив; // ={35,24,12,2,8,74,13,99,454,12,44};	
	protected static int n,м;
	static boolean  флаг;
	static long start=0,end=0, delta=0;
	public static void main(String[] Аргументы) {
	// n=50;
	n=20; //Inputt(" ВВедите n=");
        
	
        System.out.println(" Лена прожила "+ end + " милисек;  вычисляли  "+ (end-start) + " т.е = " + delta + " сек");
        массив = new int[n];
	start = System.currentTimeMillis() ;
	for (int i=0; i<n ; i++) массив[i]=(int)(Math.random()*n);
	// печать();
	for (;;) {
	флаг=true;
	for (int i=0; i < n-1 ; i++ ) {
	if (массив[i]>массив[i+1]) {м=массив[i]; массив[i]=массив[i+1]; массив[i+1]=м; флаг=false; }
	}
	if (флаг) break;
	}
	// печать();
	end = System.currentTimeMillis() ;
	delta=end-start;
	delta/=1000;
	System.out.println(" Лена прожила "+ end + " милисек;  вычисляли  "+ (end-start) + " т.е = " + delta + " сек");
        System.out.println(" Лена прожила "+ end + " милисек = "+ end/1000 + " сек = " + end/60000  + " часов = "+ end/(24*60*1000) + " дней " );
	}
	protected static void печать () {
	for (int i=0; i<n; i++) System.out.print(" "+ массив[i]);
	System.out.println();
	}
	static int Inputt(String ss) {
	Scanner input = new Scanner(System.in);
		for (;;) {
        	System.out.print(ss);
		if(input.hasNextInt())  // возвращает истинну если с потока ввода можно считать целое число
        		return (input.nextInt());
		System.out.println("Вы ввели не число"); 
		input.nextLine();  // очистил ввод
		}  // конец for
	} // конец inputt
	}
