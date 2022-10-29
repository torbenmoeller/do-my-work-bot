plugins {
	java
	id("org.springframework.boot") version "2.7.5"
}

apply(plugin = "io.spring.dependency-management")

group = "dev.pluvial"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
}

tasks.getByName<Test>("test") {
	useJUnitPlatform()
}