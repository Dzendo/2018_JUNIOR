package kotlincourse.contact.test

import kotlincourse.contact.gui.ContactFrame

/**
 * Класс для запуска тестовых вызовов
 */
object ContactTest {
    @JvmStatic
    fun main(args: Array<String>) {
        var cf: ContactFrame?
        cf = null
        // System.out.println(cf);
        // int a;
        // a=10;
        // System.out.println (a);
        cf = ContactFrame()
        // System.out.println ("Объект создан");
        cf.isVisible = true
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

