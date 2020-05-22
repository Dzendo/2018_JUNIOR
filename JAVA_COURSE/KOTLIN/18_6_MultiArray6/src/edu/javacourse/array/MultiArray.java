package edu.javacourse.array;

public class MultiArray
{
    public static void main(String[] args) {
        // Объявим коснтанту для размера массива
        int SIZE = 10;
        // Создаем двумерный массив 
        char[][] graph = new char[SIZE+1][SIZE+1];

        // Цикл по первой размерности (первые квадратные скобки)
        for (int i = 0; i < SIZE/2+1; i++) {
            // Цикл по второй размерности (вторые квадратные скобки)
            for (int j = 0; j < SIZE+1; j++) {
                if ( i == SIZE/2   || j == SIZE/2 - i || j==SIZE/2+i){ 
                    // Это от ДО
                    graph[i][j] = '#';
                } else {
                    graph[i][j] = ' ';
                }
            }
        }

        // Теперь выводим массив на экран
        // Цикл по первой размерности выводит строки
        for (int i = 0; i < SIZE; i++) {
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
