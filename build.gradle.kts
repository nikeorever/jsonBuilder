import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10" apply false
    id("org.jetbrains.dokka") version "1.4.0" apply false
}

allprojects {
    repositories {
        jcenter()
        mavenCentral()
        gradlePluginPortal()
    }
}

subprojects {
    group = "cn.nikeo.jsonBuilder"
    version = "0.2.0-SNAPSHOT"

    plugins.withId("org.jetbrains.kotlin.jvm") {
        tasks.withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
                freeCompilerArgs = listOf("-progressive", "-Xjvm-default=enable")
            }
        }
    }
}
