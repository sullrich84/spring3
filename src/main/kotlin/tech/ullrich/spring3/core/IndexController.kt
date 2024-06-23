package tech.ullrich.spring3.core

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.info.BuildProperties
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime

@RestController
@RequestMapping("/")
class IndexController {

    @Autowired
    lateinit var buildProperties: BuildProperties

    @RequestMapping
    fun index() = buildProperties.run {
        mapOf(
            "name" to name,
            "artifact" to artifact,
            "group" to group,
            "version" to version,
            "buildTime" to time,
            "serverTime" to OffsetDateTime.now(),
        )
    }
}
