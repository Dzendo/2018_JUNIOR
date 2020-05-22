package kotlincourse.contact.dao

/**
 * Фабрика для создания экземпляра ContactDAO
 */
object ContactDAOFactory {
    val contactDAO: ContactDAO
        get() = ContactSimpleDAO()
}
