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
            srcDirs("plainkotlin/main")
        }
    }
}

dependencies {
    implementation(libs.netwareClient)
}