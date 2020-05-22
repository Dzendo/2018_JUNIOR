package kotlincourse.contact.test

import kotlincourse.contact.business.ContactManager
import kotlincourse.contact.entity.Contact

/**
 * Класс для запуска тестовых вызовов
 */
object ContactTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val cm = ContactManager()

        val c1 = Contact("Андрей", "Соколов", "+7-911-890-7766", "sokolov@yandex.ru")
        val c2 = Contact("Сергей", "Иванов", "+7-911-890-7755", "ivanov@google.com")
        val c3 = Contact("Татьяна", "Семенова", "+7-911-890-1164", "semenova@mail.ru")

        println("ADD CONTACT ==============")
        val cId1 = cm.addContact(c1)
        val cId2 = cm.addContact(c2)
        val cId3 = cm.addContact(c3)
        val result1 = cm.findContacts()
        for (c in result1) {
            println(c)
        }

        println("UPDATE CONTACT ==============")
        val change = Contact(cId1, "Алексей", "Соколов", "+7-911-890-7766", "sokolov@yandex.ru")
        cm.updateContact(change)
        val result2 = cm.findContacts()
        for (c in result2) {
            println(c)
        }

        println("DELETE CONTACT ==============")
        cm.deleteContact(cId1)
        val result3 = cm.findContacts()
        for (c in result3) {
            println(c)
        }

        println("GET CONTACT ==============")
        val contact = cm.getContact(cId2)
        println(contact)
    }

}
