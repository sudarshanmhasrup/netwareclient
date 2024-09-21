plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.java)
    alias(libs.plugins.mavenPublish)
    kotlin("plugin.serialization") version "1.9.10"
}

group = "com.github.sudarshanmhasrup"
version = "0.0.1-alpha"

repositories {
    mavenCentral()
}

dependencies {
    api(libs.json)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    testImplementation(libs.jupiter)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)

        repositories {
            mavenCentral()
            gradlePluginPortal()
        }
    }


    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.test {
    useJUnitPlatform()
}

// Publication
publishing {

    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            groupId = "com.github.sudarshanmhasrup"
            artifactId = "netwareclient"
            version = "0.0.1-alpha"
        }

        repositories {
            mavenLocal()
        }
    }
}