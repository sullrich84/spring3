package tech.ullrich.spring3.foo.persistence

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.data.rest.core.annotation.*
import tech.ullrich.spring3.foo.service.FooService

@RepositoryEventHandler
class FooEntityHandler(private val service: FooService) {

    private val logger = KotlinLogging.logger {}

    @HandleAfterCreate
    fun handleAfterCreateFooEntity(foo: FooEntity) {
        logger.info { "Created Foo Entity: $foo" }
        service.afterCreate(foo)
    }

    @HandleAfterDelete
    fun handleAfterDeleteFooEntity(foo: FooEntity) {
        logger.info { "Deleted Foo Entity: $foo" }
        service.afterDelete(foo)
    }
}
