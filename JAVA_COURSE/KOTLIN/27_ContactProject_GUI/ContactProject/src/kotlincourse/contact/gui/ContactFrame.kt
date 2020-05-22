package kotlincourse.contact.gui

import kotlincourse.contact.business.ContactManager
import kotlincourse.contact.entity.Contact

import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class ContactFrame : JFrame(), ActionListener {

    private val contactManager = ContactManager()
    private val contactTable = JTable()

    // В конструкторе мы создаем нужные элементы
    init {
        // Выставляем у таблицы свойство, которое позволяет выделить
        // ТОЛЬКО одну строку в таблице
        contactTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION)

        // Используем layout GridBagLayout
        val gridbag = GridBagLayout()
        val gbc = GridBagConstraints()
        // Каждый элемент является последним в строке
        gbc.gridwidth = GridBagConstraints.REMAINDER
        // Элемент раздвигается на весь размер ячейки
        gbc.fill = GridBagConstraints.BOTH
        // Но имеет границы - слева, сверху и справа по 5. Снизу - 0
        gbc.insets = Insets(5, 5, 0, 5)

        // Создаем панель для кнопок
        val btnPanel = JPanel()
        // усанавливаем у него layout
        btnPanel.layout = gridbag
        // Создаем кнопки и укзаываем их загловок и ActionCommand
        btnPanel.add(createButton(gridbag, gbc, "Обновить", LOAD))
        btnPanel.add(createButton(gridbag, gbc, "Добавить", ADD))
        btnPanel.add(createButton(gridbag, gbc, "Исправить", EDIT))
        btnPanel.add(createButton(gridbag, gbc, "Удалить", DELETE))

        // Создаем панель для левой колокни с кнопками
        val left = JPanel()
        // Выставляем layout BorderLayout
        left.layout = BorderLayout()
        // Кладем панель с кнопками в верхнюю часть
        left.add(btnPanel, BorderLayout.NORTH)
        // Кладем панель для левой колонки на форму слева - WEST
        add(left, BorderLayout.WEST)

        // Кладем панель со скролингом, внутри которой нахоится наша таблица
        // Теперь таблица может скроллироваться
        add(JScrollPane(contactTable), BorderLayout.CENTER)

        // выставляем координаты формы
        setBounds(100, 200, 900, 400)
        // При закрытии формы заканчиваем работу приложения
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        // Загружаем контакты
        loadContact()
    }

    // Метод создает кнопку с заданными харктеристиками - заголовок и действие
    private fun createButton(gridbag: GridBagLayout, gbc: GridBagConstraints, title: String, action: String): JButton {
        // Создаем кнопку с заданным загловком
        val button = JButton(title)
        // Действие будетп роверяться в обработчике и мы будем знать, какую
        // именно кнопку нажали
        button.actionCommand = action
        // Обработчиком события от кнопки являемся сама форма
        button.addActionListener(this)
        // Выставляем свойства для размещения для кнопки
        gridbag.setConstraints(button, gbc)
        return button
    }

    override// Обработка нажатий кнопок
    fun actionPerformed(ae: ActionEvent) {
        // Получаем команду - ActionCommand
        val action = ae.actionCommand
        // В зависимости от команды выполняем действия
        when (action) {
            // Перегрузка данных
            LOAD -> loadContact()
            // Добавление записи
            ADD -> addContact()
            // Исправление записи
            EDIT -> editContact()
            // Удаление записи
            DELETE -> deleteContact()
        }
    }

    // Загрухить список контактов
    private fun loadContact() {
        // Обращаемся к классу для загрузки списка контактов
        val contacts = contactManager.findContacts()
        // Создаем модель, которой передаем полученный список
        val cm = ContactModel(contacts)
        // Передаем нашу модель таблице - и она может ее отображать
        contactTable.model = cm
    }

    // Добавление контакта
    private fun addContact() {
        // Создаем диалог для ввода данных
        val ecd = EditContactDialog()
        // Обрабатываем закрытие диалога
        saveContact(ecd)
    }

    // Редактирование контакта
    private fun editContact() {
        // Получаем выделеннуб строку
        val sr = contactTable.selectedRow
        // если строка выделена - можно ее редактировать
        if (sr != -1) {
            // Получаем ID контакта
            val id = java.lang.Long.parseLong(contactTable.model.getValueAt(sr, 0).toString())
            // получаем данные контакта по его ID
            val cnt = contactManager.getContact(id)
            // Создаем диалог для ввода данных и передаем туда контакт
            val ecd = EditContactDialog(contactManager.getContact(id))
            // Обрабатываем закрытие диалога
            saveContact(ecd)
        } else {
            // Если строка не выделена - сообщаем об этом
            JOptionPane.showMessageDialog(this, "Вы должны выделить строку для редактирования")
        }
    }

    // Удаление контакта
    private fun deleteContact() {
        // Получаем выделеннуб строку
        val sr = contactTable.selectedRow
        if (sr != -1) {
            // Получаем ID контакта
            val id = java.lang.Long.parseLong(contactTable.model.getValueAt(sr, 0).toString())
            // Удаляем контакт
            contactManager.deleteContact(id)
            // перегружаем список контактов
            loadContact()
        } else {
            JOptionPane.showMessageDialog(this, "Вы должны выделить строку для удаления")
        }
    }

    // Общий метод для добавления и изменения контакта
    private fun saveContact(ecd: EditContactDialog) {
        // Если мы нажали кнопку SAVE
        if (ecd.isSave) {
            // Получаем контакт из диалогового окна
            val cnt = ecd.contact
            if (cnt.contactId != null) {
                // Если ID у контакта есть, то мы его обновляем
                contactManager.updateContact(cnt)
            } else {
                // Если у контакта нет ID - значит он новый и мы его добавляем
                contactManager.addContact(cnt)
            }
            loadContact()
        }
    }

    companion object {
        private val LOAD = "LOAD"
        private val ADD = "ADD"
        private val EDIT = "EDIT"
        private val DELETE = "DELETE"
    }
}
