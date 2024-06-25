package tech.ullrich.spring3.foo.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.UUID

@RepositoryRestResource(collectionResourceRel = "foos", path = "foos", itemResourceRel = "foo")
interface FooRepository : JpaRepository<FooEntity, UUID>
