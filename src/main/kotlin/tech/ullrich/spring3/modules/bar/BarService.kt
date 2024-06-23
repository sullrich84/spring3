package tech.ullrich.spring3.modules.bar

import org.springframework.stereotype.Service
import tech.ullrich.spring3.modules.foo.FooService

@Service
class BarService(private val barRepository: BarRepository, private val fooService: FooService) {
}
