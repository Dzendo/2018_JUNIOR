package kotlincourse.contact.gui

import kotlincourse.contact.entity.Contact

import javax.swing.table.AbstractTableModel

class ContactModel(// Здесь мы храним список контактов, которые будем отображать в таблице
        private val contacts: List<Contact>) : AbstractTableModel() {

    override// Получить количество строк в таблице - у нас это размер коллекции
    fun getRowCount(): Int {
        return contacts.size
    }

    override// Получить количество столбцов - их у нас стольк же, сколько полей
    // у класса Contact - всего пять
    fun getColumnCount(): Int {
        return 5
    }

    override// Вернуть загловок колонки - мы его берем из массива headers
    fun getColumnName(col: Int): String {
        return headers[col]
    }

    override// Получить объект для тображения в кокнретной ячейке таблицы
    // В данном случае мы отдаем строковое представление поля
    fun getValueAt(row: Int, col: Int): Any? {
        val contact = contacts[row]
        // В зависимости от номера колонки возвращаем то или иное поле контакта
        when (col) {
            0 -> return contact.contactId!!.toString()
            1 -> return contact.firstName
            2 -> return contact.lastName
            3 -> return contact.email
            else -> return contact.phone
        }
    }

    companion object {
        // Список загловков для колонок в таблице
        private val headers = arrayOf("ID", "Имя", "Фамилия", "Email", "Телефон")
    }
}
