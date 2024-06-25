package tech.ullrich.spring3

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter
import org.springframework.modulith.test.ApplicationModuleTest

@ApplicationModuleTest
class ModularityTest {

    @Test
    fun verifyModularity() {
        val modules = ApplicationModules
            .of(Spring3Application::class.java)
            .verify()

        modules.forEach { mod -> println(mod) }

        Documenter(modules)
            .writeModulesAsPlantUml()
            .writeIndividualModulesAsPlantUml()
    }
}
