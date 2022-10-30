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
	implementation("com.squareup.okhttp3:okhttp:4.10.0")
	implementation("com.slack.api:bolt-servlet:1.26.1")
	implementation("org.gitlab4j:gitlab4j-api:5.0.1")
}

tasks.getByName<Test>("test") {
	useJUnitPlatform()
}
