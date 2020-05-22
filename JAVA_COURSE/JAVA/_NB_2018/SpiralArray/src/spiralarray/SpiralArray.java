/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiralarray;

/*
 Заполнение по спирали двумерного массива со сторонами А Х В любого размера
 при условии, что А = В
 */
public class SpiralArray {
 
    public static void main(String[] args) {
        // Выбираем размер стороны квадрата и рассчитываем общее количество элементов массива
        int Size = 16;
        int Max = Size * Size;
        /*
         координаты и рамки заполнения массива
         x[0],y[0] – нижние динамические границы
         x[1],y[1] – верхние динамические границы
         x[2],y[2] – текущие координаты
         x[3],y[3] – вектор смещения
         */
        int RC = 4;
        int[] x = new int[RC];
        int[] y = new int[RC];
        // Объявляем массив для заполнения
        int[][] Sp = new int[Size][Size];
        // Задаём начальные значения координат и рамок
        for (int i = 0; i < RC; i++) {
            x[i] = y[i] = 0;
        }
        x[1] = y[1] = Size - 1;
        x[3] = 1;
        // Заполняем массив
        for (int i = 0; i < Max; i++) {
            //Используем массив как координатное поле
            Sp[x[2]][y[2]] = i + 1;
            // Рассчитываем текущие координаты
            x[2] = x[2] + x[3];
            y[2] = y[2] + y[3];
            // Рассчёт вектора смещения
            if (y[3] == 0) {
                if ((x[2] > x[0]) && (x[3] > 0)) {
                    x[3] = 1;
                }
                if ((x[2] < x[1]) && (x[3] < 0)) {
                    x[3] = -1;
                }
                if ((x[2] == x[1]) && (x[3] > 0)) {
                    x[3] = 0;
                    x[1]--;
                    y[3] = 1;
                }
                if ((x[2] == x[0]) && (x[3] < 0)) {
                    x[3] = 0;
                    x[0]++;
                    y[3] = -1;
                }
            }
            if (x[3] == 0) {
                if ((y[2] > y[0]) && (y[3] > 0)) {
                    y[3] = 1;
                }
                if ((y[2] < y[1]) && (y[3] < 0)) {
                    y[3] = -1;
                }
                if ((y[2] == y[1]) && (y[3] > 0)) {
                    y[3] = 0;
                    y[1]--;
                    x[3] = -1;
                }
                if ((y[2] == x[0]) && (y[3] < 0)) {
                    y[3] = 0;
                    y[0]++;
                    x[3] = 1;
                }
            }
        }
        // Печать массива заполненного данными по спирали
        System.out.println();
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                System.out.format("%4d", Sp[j][i]);
            }
            System.out.println();
        }
    }
}