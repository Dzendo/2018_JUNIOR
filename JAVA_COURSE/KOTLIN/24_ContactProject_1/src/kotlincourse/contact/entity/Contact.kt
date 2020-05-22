package kotlincourse.contact.entity

/**
 * Класс для хранения данных контакта
 */
class Contact {
    // Идентификатор контакта
    var contactId: Long? = null
    // Имя
    var firstName: String? = null
    // Фамилия
    var lastName: String? = null
    // Телефон
    var phone: String? = null
    // email
    var email: String? = null

    constructor() {}

    constructor(firstName: String, lastName: String,
                phone: String, email: String) {
        this.firstName = firstName
        this.lastName = lastName
        this.phone = phone
        this.email = email
    }

    constructor(contactId: Long?, firstName: String, lastName: String,
                phone: String, email: String) {
        this.contactId = contactId
        this.firstName = firstName
        this.lastName = lastName
        this.phone = phone
        this.email = email
    }

    override fun toString(): String {
        return "Contact{" + "contactId=" + contactId +
                ", firstName=" + firstName + ", lastName=" + lastName +
                ", phone=" + phone + ", email=" + email + '}'.toString()
    }
}
