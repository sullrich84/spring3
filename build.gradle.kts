plugins {
	kotlin("jvm") version "1.9.24"
	kotlin("plugin.jpa") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"

	id("org.springframework.boot") version "3.3.1"
	id("org.graalvm.buildtools.native") version "0.10.2"
	id("io.spring.dependency-management") version "1.1.5"
	id("org.springframework.cloud.contract") version "4.1.3"
}

group = "tech.ullrich"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2023.0.2"
extra["springModulithVersion"] = "1.2.0"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.modulith:spring-modulith-starter-core")
	implementation("org.springframework.modulith:spring-modulith-starter-jpa")
	implementation("org.springframework.boot:spring-boot-docker-compose")
	implementation("io.github.oshai:kotlin-logging-jvm:5.1.0")

	runtimeOnly("org.springframework.modulith:spring-modulith-observability")
	runtimeOnly("org.springframework.modulith:spring-modulith-starter-insight")
	runtimeOnly("org.springframework.modulith:spring-modulith-actuator")
	runtimeOnly("io.micrometer:micrometer-registry-prometheus")
	runtimeOnly("org.postgresql:postgresql")

	implementation("io.micrometer:micrometer-tracing-bridge-brave")
	implementation("io.zipkin.reporter2:zipkin-reporter-brave")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.springframework.cloud:spring-cloud-starter-contract-stub-runner")
	testImplementation("org.springframework.cloud:spring-cloud-starter-contract-verifier")
	testImplementation("org.springframework.modulith:spring-modulith-starter-test")

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.modulith:spring-modulith-bom:${property("springModulithVersion")}")
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

springBoot {
	buildInfo()
}

contracts {
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.contractTest {
	useJUnitPlatform()
}
