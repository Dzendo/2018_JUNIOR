package kotlincourse.contact.gui

import kotlincourse.contact.entity.Contact

import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class EditContactDialog @JvmOverloads constructor(contact: Contact? = null) : JDialog(), ActionListener {

    // Поле для ввода Имени
    private val txtFirstName = JTextPane()
    // Поле для ввода Фамилии
    private val txtLastName = JTextPane()
    // Поле для ввода Телефона
    private val txtPhone = JTextPane()
    // Поле для ввода E-mail
    private val txtEmail = JTextPane()

    // Поле для хранения ID контакта, если мы собираемся редактировать
    // Если это новый контакт - cjntactId == null
    private var contactId: Long? = null
    // Надо ли записывать изменения после закрытия диалога
    // Надо ли сохранять изменения
    var isSave = false
        private set

    // Создаем контакт из заполенных полей, который можно будет записать
    val contact: Contact
        get() = Contact(contactId, txtFirstName.text,
                txtLastName.text, txtPhone.text, txtEmail.text)

    init {
        // Убираем layout - будем использовать абсолютные координаты
        layout = null

        // Выстраиваем метки и поля для ввода
        buildFields()
        // Если нам передали контакт - заполняем поля формы
        initFields(contact)
        // выстариваем кнопки
        buildButtons()

        // Диалог в модальном режиме - только он активен
        isModal = true  // Изменил ДО
        // Запрещаем изменение размеров
        isResizable = false
        // Выставляем размеры формы
        setBounds(300, 300, 450, 200)
        // Делаем форму видимой
        isVisible = true
    }

    // Размещаем метки и поля ввода на форме
    private fun buildFields() {
        // Набор метки и поля для Имени
        val lblFirstName = JLabel("Имя:")
        // Выравнивание текста с правой стороны
        lblFirstName.horizontalAlignment = SwingConstants.RIGHT
        // Выставляем координаты метки
        lblFirstName.bounds = Rectangle(PAD, 0 * H_B + PAD, W_L, H_B)
        // Кладем метку на форму
        add(lblFirstName)
        // Выставляем координаты поля
        txtFirstName.bounds = Rectangle(W_L + 2 * PAD, 0 * H_B + PAD, W_T, H_B)
        // Делаем "бордюр" для поля
        txtFirstName.border = BorderFactory.createEtchedBorder()
        // Кладем поле на форму
        add(txtFirstName)

        // Набор метки и поля для Фамилии
        val lblLastName = JLabel("Фамилия:")
        lblLastName.horizontalAlignment = SwingConstants.RIGHT
        lblLastName.bounds = Rectangle(PAD, 1 * H_B + PAD, W_L, H_B)
        add(lblLastName)
        txtLastName.bounds = Rectangle(W_L + 2 * PAD, 1 * H_B + PAD, W_T, H_B)
        txtLastName.border = BorderFactory.createEtchedBorder()
        add(txtLastName)

        // Набор метки и поля для Телефона
        val lblPhone = JLabel("Телефон:")
        lblPhone.horizontalAlignment = SwingConstants.RIGHT
        lblPhone.bounds = Rectangle(PAD, 2 * H_B + PAD, W_L, H_B)
        add(lblPhone)
        txtPhone.bounds = Rectangle(W_L + 2 * PAD, 2 * H_B + PAD, W_T, H_B)
        txtPhone.border = BorderFactory.createEtchedBorder()
        add(txtPhone)

        // Набор метки и поля для Email
        val lblEmail = JLabel("Email:")
        lblEmail.horizontalAlignment = SwingConstants.RIGHT
        lblEmail.bounds = Rectangle(PAD, 3 * H_B + PAD, W_L, H_B)
        add(lblEmail)
        txtEmail.bounds = Rectangle(W_L + 2 * PAD, 3 * H_B + PAD, W_T, H_B)
        txtEmail.border = BorderFactory.createEtchedBorder()
        add(txtEmail)
    }

    // Если нам епередали контакт - заполняем поля из контакта
    private fun initFields(contact: Contact?) {
        if (contact != null) {
            contactId = contact.contactId
            txtFirstName.text = contact.firstName
            txtLastName.text = contact.lastName
            txtEmail.text = contact.email
            txtPhone.text = contact.phone
        }
    }

    // Размещаем кнопки на форме
    private fun buildButtons() {
        val btnSave = JButton("SAVE")
        btnSave.actionCommand = SAVE
        btnSave.addActionListener(this)
        btnSave.bounds = Rectangle(PAD, 5 * H_B + PAD, W_B, H_B)
        add(btnSave)

        val btnCancel = JButton("CANCEL")
        btnCancel.actionCommand = CANCEL
        btnCancel.addActionListener(this)
        btnCancel.bounds = Rectangle(W_B + 2 * PAD, 5 * H_B + PAD, W_B, H_B)
        add(btnCancel)
    }

    override// Обработка нажатий кнопок
    fun actionPerformed(ae: ActionEvent) {
        val action = ae.actionCommand
        // Если нажали кнопку SAVE (сохранить изменения) - запоминаем этой
        isSave = SAVE == action
        // Закрываем форму
        isVisible = false
    }

    companion object {
        // Заголовки кнопок
        private val SAVE = "SAVE"
        private val CANCEL = "CANCEL"

        // Размер отступа
        private val PAD = 10
        // Ширина метки
        private val W_L = 100
        //Ширина поля для ввода
        private val W_T = 300
        // Ширина кнопки
        private val W_B = 120
        // высота элемента - общая для всех
        private val H_B = 25
    }
}
