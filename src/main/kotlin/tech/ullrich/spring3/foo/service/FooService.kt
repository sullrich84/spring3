package tech.ullrich.spring3.foo.service

import org.springframework.stereotype.Service
import tech.ullrich.spring3.foo.persistence.FooEntity

@Service
class FooService {

    fun afterCreate(foo: FooEntity) {
        Thread.sleep(200)
    }

    fun afterDelete(foo: FooEntity) {
        Thread.sleep(200)
    }
}
