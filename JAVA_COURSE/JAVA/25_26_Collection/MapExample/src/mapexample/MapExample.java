/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapexample;

/**
 *
 * @author LV
 */
import java.util.HashMap;
import java.util.Map;
 
public class MapExample
{
    public static void main(String[] args) {
        // HashMap - наверно самый распространенный класс - но есть и другие.
        Map<String, WebSiteUser> mapItems = new HashMap<>();
        
        // Создаем объекты
        WebSiteUser w1 = new WebSiteUser("andy@google.com", "Andy", "Collah", "+1-467-98763245");
        WebSiteUser w2 = new WebSiteUser("john@yahoo.com", "John", "Smith", "+1-467-9870574426");
        WebSiteUser w3 = new WebSiteUser("cris@gmail.com", "Cris", "Balen", "+1-632-4267473426");
 
        // Помещаем объекты в коллекцию - ключом является поле email
        mapItems.put(w1.getEmail(), w1);
        mapItems.put(w2.getEmail(), w2);
        mapItems.put(w3.getEmail(), w3);
        // Еще раз вставляем объект, но с другим ключом
        mapItems.put("other@yandex.ru", w3);
        
        // Получить объет по ключу
        System.out.println("Получить пользователя по ключу");
        WebSiteUser user = mapItems.get("cris@gmail.com");
        System.out.println("User:" + user.getFirstName() + ":" + user.getLastName());
        
        // Пройти по коллекции из ключей - доступ к коллекции ключей через keySet()
        System.out.println();
        System.out.println("Список пользователей по ключу:");
        for(String email : mapItems.keySet()) {
            // Получить объект по ключу
            WebSiteUser u = mapItems.get(email);
            System.out.println("User:" + email + ", " + u.getFirstName() + ":" + u.getLastName());
        }
 
        // Пройти по коллекции из значений - доступ к коллекции значений через values()
        System.out.println();
        System.out.println("Список пользователей по значению:");
        for(WebSiteUser us : mapItems.values()) {
            System.out.println("User:" + us.getFirstName() + ":" + us.getLastName());
        }
 
        // Пройти по коллекции из пар - доступ к коллекции через entrySet()
        System.out.println();
        System.out.println("Список пользователей в виде пар:");
        for(Map.Entry<String, WebSiteUser> us : mapItems.entrySet()) {
            System.out.println("User:" + us.getKey() + ", " + us.getValue().getFirstName() + ":" + us.getValue().getLastName());
        }
    }
}
