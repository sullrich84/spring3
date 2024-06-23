package tech.ullrich.spring3

import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.test.ApplicationModuleTest

@DataJpaTest
@ApplicationModuleTest
class ModularityTest {

    @Test
    fun verifyModularity() {
        ApplicationModules.of(Spring3Application::class.java).verify()
    }

    @Test
    fun verifyModuleModularity() {
        ApplicationModules.of("tech.ullrich.spring3.modules").verify()
    }
}
