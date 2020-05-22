package kotlincourse.contact.dao

import kotlincourse.contact.entity.Contact

/**
 * Интерфейс для определения функций хранлиза данных о контактах
 */
interface ContactDAO {
    // Добавление контакта - возвращает ID добавленного контакта
    fun addContact(contact: Contact): Long?

    // Редактирование контакта
    fun updateContact(contact: Contact)

    // Удаление контакта по его ID
    fun deleteContact(contactId: Long?)

    // Получение контакта
    fun getContact(contactId: Long?): Contact?

    // Получение списка контактов
    fun findContacts(): List<Contact>

}
