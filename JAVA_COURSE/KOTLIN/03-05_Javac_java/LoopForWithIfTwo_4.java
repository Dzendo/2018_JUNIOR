public class LoopForWithIfTwo_4
{
    public static void main(String[] arg) {
        int count = 20;
 
        // ������� ����
        for (int i = 0; i <= count; i++) {
            for (int k = 0; k <= count; k++) {
                // ����� ������� ���� ������� �����
                if (k == count/2+i || k == count/2-i || k == count/2-(count-i) || k == count/2+(count-i)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            // ������� �� ��������� ������
            System.out.println();
        }
 
    }
}