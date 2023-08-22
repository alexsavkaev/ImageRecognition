import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.9.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    dependencies {
        implementation ("org.jetbrains.kotlinx:kotlin-deeplearning-tensorflow:0.5.2")
        implementation ("org.jetbrains.kotlinx:kotlin-deeplearning-onnx:0.5.2")
        implementation ("org.jetbrains.kotlinx:kotlin-deeplearning-visualization:0.5.2")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}