public class LoopForWithIfTwo_1
{
    public static void main(String[] arg) {
        int count = 10;
 
        // Внешний цикл
        for (int i = 0; i < count; i++) {
            for (int k = 0; k < count; k++) {
                // Здесь условие даже немного проще
                if (i == 0 || k == 0 || k == count-1 || i == count - 1 || k == i || k == count-i-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            // Переход на следующую строку
            System.out.println();
        }
 
    }
}