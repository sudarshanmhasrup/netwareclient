plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.java)
    alias(libs.plugins.mavenPublish)
}

group = "com.github.sudarshanmhasrup"
version = "0.0.1-alpha"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
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