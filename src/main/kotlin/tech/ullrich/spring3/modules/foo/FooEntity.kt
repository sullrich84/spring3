package tech.ullrich.spring3.modules.foo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.UUID

@Entity(name = "foo")
class FooEntity {

    @Id
    @GeneratedValue
    var uuid: UUID = UUID.randomUUID()

    var name: String = "n/a"

    var value: Long = 0
}
