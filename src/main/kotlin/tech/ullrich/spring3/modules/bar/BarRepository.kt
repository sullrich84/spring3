package tech.ullrich.spring3.modules.bar

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.UUID

@RepositoryRestResource(collectionResourceRel = "bars", path = "bars", itemResourceRel = "bar")
interface BarRepository : JpaRepository<BarEntity, UUID>{
}
