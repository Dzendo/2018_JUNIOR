public class Второй
{
	public static int Первый;
	public static Второй второй; 
    Второй (int Вход){Первый = Вход;}
	
    public static void main(String[] Аргументы) {
        int counter = 99;
        int счетчик = 90;
	счетчик += counter;
	второй = new Второй(150);
	// второй.Инициализация(140);
        System.out.println(Первый+" счетчик = "+счетчик);
    }
	 void Инициализация(int Вход) { Первый= Вход; return; } 
}