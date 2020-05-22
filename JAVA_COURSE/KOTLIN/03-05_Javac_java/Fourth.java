// переделал Дима в вычисление корней 07,06,2018  a*x**2+b*x+c 
import static java.lang.Math.*;
import java.util.Scanner; 
public class Fourth
{	static double a=0,b=0,c=0;

    public static void main(String[] arg) {
	double D;
	System.out.println(" Начало программы вычисление корней квадратного уравнения ДО 07,06,2018");
       	for (;;){
		a=Inputt(" ВВедите а=");
		b=Inputt(" ВВедите b=");
		c=Inputt(" ВВедите c=");
		if (a==0 & b==0 & c==0) break;
	
		D=b*b-4*a*c;  // Вычисляю Дискриминант
		if (D<=0) { System.out.println("С Комлексными не работаю D="+D);  continue;}
	       	
		Проверка((-b+sqrt(D))/(2*a));
		Проверка((-b-sqrt(D))/(2*a));
	}  // конец for
	System.out.println(" Конец программы вычисление корней квадратного уравнения ДО 07,06,2018");
    }   // конец main

	static double Inputt(String ss) {
	Scanner input = new Scanner(System.in);
		for (;;) {
        	System.out.print(ss);
		if(input.hasNextDouble())  // возвращает истинну если с потока ввода можно считать целое число
        		return (input.nextDouble());
		System.out.println("Вы ввели не число"); 
		input.nextLine();  // очистил ввод
		}  // конец for
	} // конец inputt
	static void Проверка(double x) {
	// проверка корня
	System.out.println(" Корень = "+ x + " Проверка !! = " + a*x*x+b*x+c);
	} // конец Проверка
}  // Конец Class