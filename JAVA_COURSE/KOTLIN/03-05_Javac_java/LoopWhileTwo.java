public class LoopWhileTwo
{
    public static void main(String[] arg) {
        int count = 10;
 
        int i = 0;
        // ������ ��� - i++. ���� ���: ++i, �� �������� ����� ������
        // ������ - ����������� ����
        while (i++ < count) {
            System.out.print(i);
        }
        System.out.println();
 
    }
}