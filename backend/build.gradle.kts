import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.9.21"
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.spring") version "1.9.21"
}

group = "com.c2ri"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    /* Lombok */
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    /* DB */
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    /* JPA */
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    /* Spring Security */
    implementation("org.springframework.boot:spring-boot-starter-security")
    testImplementation("org.springframework.security:spring-security-test")
    /* JWT */
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
    /* Swagger */
    implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
    implementation("io.swagger.core.v3:swagger-annotations:2.1.6") //Swagger 내 API 설명
    /* OAuth2 */
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    //implementation ("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
