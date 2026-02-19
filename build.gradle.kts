plugins {
    kotlin("jvm") version "2.1.20"
    `java-library`
    id("org.jetbrains.dokka") version "2.1.0"
    id("com.vanniktech.maven.publish") version "0.34.0"
}

group = "io.github.fenrur"
version = System.getenv("VERSION") ?: "2.0.0"

repositories {
    mavenCentral()
    maven { url = uri("https://maven.vaadin.com/vaadin-prereleases") }
}

val vaadinVersion = "24.6.3"

dependencies {
    // Signal library
    api("io.github.fenrur:signal:3.0.0")

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
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
    }
}

tasks.test {
    useJUnitPlatform()
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()
    coordinates("io.github.fenrur", "vaadin-signal", version.toString())

    pom {
        name.set("Vaadin Signal")
        description.set("Vaadin integration for the Signal reactive library")
        url.set("https://github.com/fenrur/vaadin-signal")
        inceptionYear.set("2025")

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
            url.set("https://github.com/fenrur/vaadin-signal")
            connection.set("scm:git:git://github.com/fenrur/vaadin-signal.git")
            developerConnection.set("scm:git:ssh://github.com/fenrur/vaadin-signal.git")
        }
    }
}
