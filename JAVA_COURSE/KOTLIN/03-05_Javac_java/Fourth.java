// ��������� ���� � ���������� ������ 07,06,2018  a*x**2+b*x+c 
import static java.lang.Math.*;
import java.util.Scanner; 
public class Fourth
{	static double a=0,b=0,c=0;

    public static void main(String[] arg) {
	double D;
	System.out.println(" ������ ��������� ���������� ������ ����������� ��������� �� 07,06,2018");
       	for (;;){
		a=Inputt(" ������� �=");
		b=Inputt(" ������� b=");
		c=Inputt(" ������� c=");
		if (a==0 & b==0 & c==0) break;
	
		D=b*b-4*a*c;  // �������� ������������
		if (D<=0) { System.out.println("� ����������� �� ������� D="+D);  continue;}
	       	
		��������((-b+sqrt(D))/(2*a));
		��������((-b-sqrt(D))/(2*a));
	}  // ����� for
	System.out.println(" ����� ��������� ���������� ������ ����������� ��������� �� 07,06,2018");
    }   // ����� main

	static double Inputt(String ss) {
	Scanner input = new Scanner(System.in);
		for (;;) {
        	System.out.print(ss);
		if(input.hasNextDouble())  // ���������� ������� ���� � ������ ����� ����� ������� ����� �����
        		return (input.nextDouble());
		System.out.println("�� ����� �� �����"); 
		input.nextLine();  // ������� ����
		}  // ����� for
	} // ����� inputt
	static void ��������(double x) {
	// �������� �����
	System.out.println(" ������ = "+ x + " �������� !! = " + a*x*x+b*x+c);
	} // ����� ��������
}  // ����� Class