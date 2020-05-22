public class LoopForWithIfTwo_3
{
    public static void main(String[] arg) {
        int count = 10;
 
        // Внешний цикл
        for (int i = 0; i < count/2+1; i++) {
            for (int k = 0; k <= count; k++) {
                // Здесь условие даже немного проще
                if (i == count/2 || k == count/2+i || k == count/2-i) {
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