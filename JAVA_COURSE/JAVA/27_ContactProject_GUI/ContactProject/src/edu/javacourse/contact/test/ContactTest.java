package edu.javacourse.contact.test;

import edu.javacourse.contact.gui.ContactFrame;

/**
 * Класс для запуска тестовых вызовов
 */
public class ContactTest 
{
    public static void main(String[] args) {
        ContactFrame cf;
        cf=null;
       // System.out.println(cf);
       // int a;
       // a=10;
       // System.out.println (a);
        cf= new ContactFrame();
       // System.out.println ("Объект создан");
        cf.setVisible(true);
        /*
         ContactFrame cf1;
        cf=null;
       // System.out.println(cf);
       // int a;
       // a=10;
       // System.out.println (a);
        cf1= new ContactFrame();
       // System.out.println ("Объект создан");
        cf1.setVisible(true);
        */
    }
}

