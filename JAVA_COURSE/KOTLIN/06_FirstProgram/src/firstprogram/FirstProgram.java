package firstprogram;
import static java.lang.System.*;
import static java.lang.Math.*;



public class FirstProgram {
     static { System.out.println("Static START БЛОК ИНИТ static"  );}
    //static { Second.printtt();}
    //private static Second sec= new Second();
    static {
       
        stat = "Start";
        new FirstProgram();
         System.out.println("БЛОК ИНИТ static"  );
                
}
    static private  String stat = "static 1";          // класса
    private        String stringobj="odj"+"1";       // объекта потом
       private static String stat1 = printt();
      private static FirstProgram program= new FirstProgram();
      private static String stat2=stat+" stat 2";
      
      {                        // при сщздании объекта этого класса
             out.println("БЛОК ИНИТ1 объекта"+ stat + " "+stat2 );    
                
                
            }
     
      static {
        stat = "Start";
         System.out.println("БЛОК ИНИТ static"  );
                /* System.out.println("БЛОК ИНИТ static"+ stat + " "+stat2 ); 
                 stat=stat+" 2";   // при создании класса
       System.out.println("Создан Класс "+ stat + " "+stat2 ); 
        
      program= new FirstProgram();
      stat=stat+" 3";
      System.out.println("Static после создания объекта "+ stat); 
        System.out.println("КОНЕЦ БЛОК ИНИТ "+ stat + " "+stat2 ); */
                 
}
     
       
      
            {                        // при сщздании объекта этого класса
             System.out.println("БЛОК ИНИТ2 объекта"+ stat + " "+stat2 );    
                
                
            }
            public FirstProgram(){ 
                System.out.println("конструктор"  );
            }
               
             
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Привет Дима"); 
        System.out.println("Привет Дима"); 

    }
    public static String printt(){
   System.out.println(" printt: Создан Класс перед static "+ stat1+" " +stat2);
       return (stat);
    }

    
}
