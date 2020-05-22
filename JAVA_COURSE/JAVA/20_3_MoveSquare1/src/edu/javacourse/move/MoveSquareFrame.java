package edu.javacourse.move;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MoveSquareFrame extends JFrame
{
    public static final String UP = "UP";
    public static final String DOWN = "DOWN";
    public static final String LEFT ="LEFT";
    public static final String RIGHT = "RIGHT";
    
    public MoveSquareFrame() {
        SquareComponent sc = new SquareComponent();
        // Кладем компонент для рисования квадрата
        add(sc);
        
        // Создаем кнопку для посылки команды движения вверх
        JButton btnUp = new JButton(UP);
        // Устанавливаем ей идентификатор, по которому сможем узнать эту кнопку
        btnUp.setActionCommand(UP);
        // Устанавливаем ей слушатель - компонент для рисования квадрата
        btnUp.addActionListener(sc);
        // Кладем кнопку на самый верх формы - на север
        add(btnUp, BorderLayout.NORTH);
        
        // Создаем кнопку для посылки команды движения вниз
        JButton btnDown = new JButton(DOWN);
        // Устанавливаем ей идентификатор, по которому сможем узнать эту кнопку
        btnDown.setActionCommand(DOWN);
        // Устанавливаем ей слушатель - компонент для рисования квадрата
        btnDown.addActionListener(sc);
        // Кладем кнопку на самый низ формы - на юг
        add(btnDown, BorderLayout.SOUTH);
        
        // Создаем кнопку для посылки команды движения влево
        JButton btnLeft = new JButton(LEFT);
        // Устанавливаем ей идентификатор, по которому сможем узнать эту кнопку
        btnLeft.setActionCommand(LEFT);
        // Устанавливаем ей слушатель - компонент для рисования квадрата
        btnLeft.addActionListener(sc);
        // Кладем кнопку на самый левый край формы - на запад
        add(btnLeft, BorderLayout.WEST);
        
        // Создаем кнопку для посылки команды движения вправо
        JButton btnRight = new JButton(RIGHT);
        // Устанавливаем ей идентификатор, по которому сможем узнать эту кнопку
        btnRight.setActionCommand(RIGHT);
        // Устанавливаем ей слушатель - компонент для рисования квадрата
        btnRight.addActionListener(sc);
        // Кладем кнопку на самый правый край формы - на восток
        add(btnRight, BorderLayout.EAST);
        
        // Устанавливаем координаты
        setBounds(100, 100, 800, 800);
    }
}
