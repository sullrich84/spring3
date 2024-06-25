package tech.ullrich.spring3.bar.service

import org.springframework.stereotype.Service
import tech.ullrich.spring3.bar.persistence.BarRepository
import tech.ullrich.spring3.foo.service.FooService

@Service
class BarService(val barRepository: BarRepository, val fooService: FooService) {

    fun doSomething() {
        barRepository.findAll()
    }
}
