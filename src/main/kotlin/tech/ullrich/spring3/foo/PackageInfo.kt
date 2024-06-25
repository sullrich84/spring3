package tech.ullrich.spring3.foo

import org.springframework.modulith.ApplicationModule
import org.springframework.modulith.PackageInfo

@PackageInfo
@ApplicationModule(allowedDependencies = ["bar"])
object PackageInfo
