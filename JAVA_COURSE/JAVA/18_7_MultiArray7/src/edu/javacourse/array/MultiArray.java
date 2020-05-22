package edu.javacourse.array;

public class MultiArray
{
    public static void main(String[] args) {
        // Объявим коснтанту для размера массива
        int SIZE = 26;
        // Создаем двумерный массив 
        char[][] graph = new char[SIZE+1][SIZE+1];

        // Цикл по первой размерности (первые квадратные скобки)
        for (int i = 0; i < SIZE+1; i++) {
            // Цикл по второй размерности (вторые квадратные скобки)
            for (int j = 0; j < SIZE+1; j++) {
                if ( j == SIZE/2 - i || j==SIZE/2+i || 
                       i-SIZE/2 == j || i-SIZE/2==SIZE-j ){ 
                    // Это от ДО
                    graph[i][j] = '#';
                } else {
                    graph[i][j] = ' ';
                }
            }
        }

        // Теперь выводим массив на экран
        // Цикл по первой размерности выводит строки
        for (int i = 0; i <= SIZE; i++) {
            // Цикл по второй размерности выводит колонки - вывод одной строки
            for (int j = 0; j <= SIZE; j++) {
                // Используем оператор print - без перехода на следующую строку
                System.out.print(graph[i][j]);
            }
            // Переход на следующую строку
            System.out.println();
        }

    }
}
