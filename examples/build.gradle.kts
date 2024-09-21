plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.java)
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(libs.netwareClient)
}

sourceSets {
    main {
        kotlin {
            srcDirs("plainKotlin/main")
        }
        java {
            srcDirs("plainJava/main")
        }
    }
}

dependencies {
    implementation(libs.netwareClient)
}