/* ������� ���������������� ��������� ���������� �������
   �� 08.06.2018 9:00
*/
	import static java.lang.Math.*;
	import java.util.Scanner; 
	public class ����������������� {
	protected static int[] ������; // ={35,24,12,2,8,74,13,99,454,12,44};	
	protected static int n,�;
	static boolean  ����;
	static long start,end, delta;
	public static void main(String[] ���������) {
	// n=50;
	n=Inputt(" ������� n=");
	������ = new int[n];
	start = System.currentTimeMillis() ;
	for (int i=0; i<n ; i++) ������[i]=(int)(Math.random()*n);
	// ������();
	for (;;) {
	����=true;
	for (int i=0; i < n-1 ; i++ ) {
	if (������[i]>������[i+1]) {�=������[i]; ������[i]=������[i+1]; ������[i+1]=�; ����=false; }
	}
	if (����) break;
	}
	// ������();
	end = System.currentTimeMillis() ;
	delta=end-start;
	delta/=1000;
	System.out.println(" ���� ������� "+ end + " �������;  ���������  "+ (end-start) + " �.� = " + delta + " ���");
        System.out.println(" ���� ������� "+ end + " ������� = "+ end/1000 + " ��� = " + end/60000  + " ����� = "+ end/(24*60*1000) + " ���� " );
	}
	protected static void ������ () {
	for (int i=0; i<n; i++) System.out.print(" "+ ������[i]);
	System.out.println();
	}
	static int Inputt(String ss) {
	Scanner input = new Scanner(System.in);
		for (;;) {
        	System.out.print(ss);
		if(input.hasNextInt())  // ���������� ������� ���� � ������ ����� ����� ������� ����� �����
        		return (input.nextInt());
		System.out.println("�� ����� �� �����"); 
		input.nextLine();  // ������� ����
		}  // ����� for
	} // ����� inputt
	}
	