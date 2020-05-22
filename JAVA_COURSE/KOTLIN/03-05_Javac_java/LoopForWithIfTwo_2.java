public class LoopForWithIfTwo_2
{
    public static void main(String[] arg) {
        int count = 10;
 
        // Внешний цикл
        for (int i = 0; i < count; i++) {
            for (int k = 0; k < count; k++) {
                // Здесь условие даже немного проще
                if (k == count-1 || i == count - 1 || k == count-i-1) {
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