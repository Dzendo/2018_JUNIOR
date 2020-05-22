/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package второй_;

/**
 *
 * @author LV
 */
public class Второй_ {
 public static int Первый;
	public static Второй_ второй; 
    Второй_ (int Вход){Первый = Вход;}
	
    public static void main(String[] Аргументы) {
        int counter = 99;
        int счетчик = 90;
	счетчик += counter;
	второй = new Второй_(150);
	// второй.Инициализация(140);
        System.out.println(Первый+" счетчик = "+счетчик);
    }
	 void Инициализация(int Вход) { Первый= Вход; return; } 
}
