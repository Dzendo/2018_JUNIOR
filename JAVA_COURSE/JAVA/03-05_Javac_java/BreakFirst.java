public class BreakFirst {
 
    public static void main(String[] arg) {
        int number = 1;   // ��������� �����
        int sum = 0;      // ���������� ��� �������� �����
        int count = 0;    // ���������� ����� - � ������ �� ������
        int max = 300;    // ������ �����
 
        for(;;) {
           sum += number;    // ����������� �����
           if(sum > 300) {   // ��������� ����� - ���� ������
               break;            // �� ��� ����� �������� ������ ������
           } else {
               count++;          // � ����� ������ ����������� ���������� �����
           }
           number += 10;    // ����������� ����� �� 10
        }
        System.out.println("Count=" + count);
    }
}