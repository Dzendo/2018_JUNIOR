package kotlinfirstprogram

import java.lang.System.out

class Second {
    private val program = FirstProgram()

    init {
        out.println("second объекта$program")
    }

    companion object {
        init {
            out.println("static second объекта")
        }

        fun printtt() {
            run {
                println("printtt second объекта")
                return
            }
        }
    }
}
