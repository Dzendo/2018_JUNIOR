package firstprogram;
import static java.lang.System.*;
public class Second {
    private FirstProgram program=new FirstProgram();
   static {out.println("static second объекта" );}
   public Second () 
    {out.println("second объекта"+ program  );}
   public static void printtt() {
       {System.out.println("printtt second объекта"  );return;}
   }
}
