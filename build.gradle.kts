plugins {
    kotlin("jvm") version "2.1.0"
    `java-library`
    `maven-publish`
}

group = "com.github.fenrur"
version = "1.0.0"

repositories {
    mavenCentral()
    maven { url = uri("https://maven.vaadin.com/vaadin-prereleases") }
    maven { url = uri("https://jitpack.io") }
}

val vaadinVersion = "24.6.3"

dependencies {
    // Signal library
    api("com.github.fenrur:signal:1.0.0")

    // Vaadin
    compileOnly("com.vaadin:vaadin:$vaadinVersion")

    // Jakarta Servlet API (required for VaadinSession)
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")

    // Testing
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.27.7")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
    withSourcesJar()
    withJavadocJar()
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
    }
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = "vaadin-signal"
            version = project.version.toString()

            from(components["java"])

            pom {
                name.set("Vaadin Signal")
                description.set("Vaadin integration for the Signal reactive library")
                url.set("https://github.com/Fenrur/vaadin-signal")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }

                developers {
                    developer {
                        id.set("fenrur")
                        name.set("Livio TINNIRELLO")
                    }
                }

                scm {
                    url.set("https://github.com/Fenrur/vaadin-signal")
                    connection.set("scm:git:git://github.com/Fenrur/vaadin-signal.git")
                    developerConnection.set("scm:git:ssh://github.com/Fenrur/vaadin-signal.git")
                }
            }
        }
    }
}
