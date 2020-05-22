package kotlincourse.contact.dao

import kotlincourse.contact.entity.Contact

import java.util.ArrayList

class ContactSimpleDAO : ContactDAO {
    private val contacts = ArrayList<Contact>()

    // Прямо в конструкторе добавляем три контакта
    init {
        addContact(Contact("Андрей", "Соколов", "+7-911-890-7766", "sokolov@yandex.ru"))
        addContact(Contact("Сергей", "Иванов", "+7-911-890-7755", "ivanov@google.com"))
        addContact(Contact("Татьяна", "Семенова", "+7-911-890-1164", "semenova@mail.ru"))
        addContact(Contact(35L, "Марина", "Сема", "+7-911-890-1165", "ma@mail.ru"))
        addContact(Contact("Андрей", "Соколов", "+7-911-890-7766", "sokolov@yandex.ru"))
        addContact(Contact("Сергей", "Иванов", "+7-911-890-7755", "ivanov@google.com"))
        addContact(Contact("Татьяна", "Семенова", "+7-911-890-1164", "semenova@mail.ru"))
        addContact(Contact(35L, "Марина", "Сема", "+7-911-890-1165", "ma@mail.ru"))
    }

    override fun addContact(contact: Contact): Long? {
        val id = generateContactId()
        contact.contactId = id
        contacts.add(contact)
        return id
    }

    override fun updateContact(contact: Contact) {
        val oldContact = getContact(contact.contactId)
        if (oldContact != null) {
            oldContact.firstName = contact.firstName
            oldContact.lastName = contact.lastName
            oldContact.phone = contact.phone
            oldContact.email = contact.email
        }
    }

    override fun deleteContact(contactId: Long?) {
        val it = contacts.iterator()
        while (it.hasNext()) {
            val cnt = it.next()
            if (cnt.contactId == contactId) {
                it.remove()
            }
        }
    }

    override fun getContact(contactId: Long?): Contact? {
        for (contact in contacts) {
            if (contact.contactId == contactId) {
                return contact
            }
        }
        return null
    }

    override fun findContacts(): List<Contact> {
        return contacts
    }

    private fun generateContactId(): Long? {
        var contactId: Long? = Math.round(Math.random() * 1000 + System.currentTimeMillis())
        while (getContact(contactId) != null) {
            contactId = Math.round(Math.random() * 1000 + System.currentTimeMillis())
        }
        return contactId
    }
}
