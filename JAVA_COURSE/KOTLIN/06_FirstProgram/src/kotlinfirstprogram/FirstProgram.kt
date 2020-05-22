package kotlinfirstprogram

import java.lang.System.out


class FirstProgram {
    private val stringobj = "odj" + "1"       // объекта потом

    init {                        // при сщздании объекта этого класса
        out.println("БЛОК ИНИТ1 объекта$stat $stat2")


    }


    init {                        // при сщздании объекта этого класса
        println("БЛОК ИНИТ2 объекта$stat $stat2")


    }

    init {
        println("конструктор")
    }

    companion object {
        init {
            println("Static START БЛОК ИНИТ static")
        }

        //static { Second.printtt();}
        //private static Second sec= new Second();
        init {

           // stat = "Start"   kot дает ошибку
            FirstProgram()
            println("БЛОК ИНИТ static")

        }

        private var stat = "static 1"          // класса
        private val stat1 = printt()
        private val program = FirstProgram()
        private val stat2 = "$stat stat 2"

        init {
            stat = "Start"
            println("БЛОК ИНИТ static")
            /* System.out.println("БЛОК ИНИТ static"+ stat + " "+stat2 );
                 stat=stat+" 2";   // при создании класса
       System.out.println("Создан Класс "+ stat + " "+stat2 );

      program= new FirstProgram();
      stat=stat+" 3";
      System.out.println("Static после создания объекта "+ stat);
        System.out.println("КОНЕЦ БЛОК ИНИТ "+ stat + " "+stat2 ); */

        }


        @JvmStatic
        fun main(args: Array<String>) {
            // TODO code application logic here
            println("Привет Дима")
            println("Привет Дима")

        }

        fun printt(): String {
            println(" printt: Создан Класс перед static $stat1 $stat2")
            return stat
        }
    }


}
