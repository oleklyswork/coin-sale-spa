import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id ("com.coditory.webjar") version "1.0.3"
    kotlin("jvm") version "1.4.31"
    kotlin("plugin.spring") version "1.4.31"
}

group = "com.coinsale"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.webjars:bootstrap:4.6.0-1")
    implementation("org.webjars:webjars-locator:0.40")
    implementation("org.webjars:font-awesome:5.15.2")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "14"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

//tasks.withType<com.coditory.gradle.webjar.WebjarInitTask> {
//    // Directory where npm puts the result
//    distDir = "dist"
//    // Directory with npm results in the jar
//    webjarDir = "static"
//
//    // NPM Task names
//    taskNames {
//        clean = "clean"
//        build = "build"
//        test = "test"
//        lint = "lint"
//        watch = "watch"
//    }
//
//    // Caching options
//    cache {
//        enabled = true
//        cacheTest = true
//        cacheLint = true
//        // Some timestamp files used for gradle caching
//        testTimestampFile = "test/timestamp"
//        lintTimestampFile = "lint/timestamp"
//        // Location of src and dest input files
//        src = listOf("src")
//        test = listOf("tests")
//    }
//}
