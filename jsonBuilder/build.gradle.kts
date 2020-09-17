@file:Suppress("UnstableApiUsage")

import org.gradle.jvm.tasks.Jar
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("jvm")
    `java-library`
    `maven-publish`
    id("org.jetbrains.dokka")
    signing
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    withSourcesJar()
}

val dokkaDir = "${buildDir}/dokka"
tasks.withType<DokkaTask> {
    outputDirectory.set(file(dokkaDir))
}

val dokkaJarTaskProvider = tasks.register<Jar>("dokkaJar") {
    archiveClassifier.set("javadoc")
    from(dokkaDir)
    dependsOn("dokkaHtml")
}

println(dokkaJarTaskProvider.get().outputs)

publishing {
    repositories {
        maven {
            url = uri("/home/xianxueliang/IdeaProjects/gradle/mavenRepository/snapshots")
        }
    }

    publications {
        create<MavenPublication>("release") {
            from(components["java"])

            artifact(dokkaJarTaskProvider.get())

            pom {
                name.set("JsonBuilder")
                description.set("An API for constructing JSON.")
                url.set("https://github.com/nikeorever/jsonBuilder")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("xianxueliang")
                        name.set("xianxueliang")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/nikeorever/jsonBuilder.git")
                    developerConnection.set("scm:git:ssh://git@github.com/nikeorever/jsonBuilder.git")
                    url.set("https://github.com/nikeorever/jsonBuilder")
                }
            }
        }
    }
}

signing {
    sign(publishing.publications["release"])
}
dependencies {
    implementation("org.json:json:20200518")
    testImplementation("junit:junit:4.13")
    testImplementation("com.google.truth:truth:1.0.1")
}