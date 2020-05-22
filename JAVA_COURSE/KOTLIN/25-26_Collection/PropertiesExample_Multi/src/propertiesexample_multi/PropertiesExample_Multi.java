/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertiesexample_multi;

/**
 *
 * @author LV
 */

import java.awt.BorderLayout;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import javax.swing.JButton;
import javax.swing.JFrame;
 
public class PropertiesExample_Multi extends JFrame
{
    public PropertiesExample_Multi() {
        // Загружаем данные из ресурса с указанием локали
        PropertyResourceBundle pr = (PropertyResourceBundle) 
                PropertyResourceBundle.getBundle("PropertiesExample_Multi.simple", new Locale("en_US"));
 
        // Получаем свойства по именам - это же по сути Map
        String upText = pr.getString("up.button.title");
        String dnText = pr.getString("dn.button.title");
 
        // Создаем кнопки с указанными названиями
        JButton up = new JButton(upText);
        JButton dn = new JButton(dnText);
        add(up, BorderLayout.NORTH);
        add(dn, BorderLayout.SOUTH);
 
        setBounds(200, 200, 500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        PropertiesExample_Multi pe = new PropertiesExample_Multi();
    }
}
