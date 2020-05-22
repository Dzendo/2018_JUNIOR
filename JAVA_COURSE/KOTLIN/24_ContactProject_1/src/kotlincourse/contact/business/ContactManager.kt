package kotlincourse.contact.business

import kotlincourse.contact.dao.ContactDAO
import kotlincourse.contact.dao.ContactDAOFactory
import kotlincourse.contact.entity.Contact

/**
 * Класс для реализации функций над списком контактов
 */
class ContactManager {
    private val dao: ContactDAO

    init {
        dao = ContactDAOFactory.contactDAO
    }

    // Добавление контакта - возвращает ID добавленного контакта
    fun addContact(contact: Contact): Long? {
        return dao.addContact(contact)
    }

    // Редактирование контакта
    fun updateContact(contact: Contact) {
        dao.updateContact(contact)
    }

    // Удаление контакта по его ID
    fun deleteContact(contactId: Long?) {
        dao.deleteContact(contactId)
    }

    // Получение одного контакта
    fun getContact(contactId: Long?): Contact? {
        return dao.getContact(contactId)
    }

    // Получение списка контактов
    fun findContacts(): List<Contact> {
        return dao.findContacts()
    }
}
