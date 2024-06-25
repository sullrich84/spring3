package tech.ullrich.spring3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Spring3Application {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<Spring3Application>(*args)
        }
    }
}
