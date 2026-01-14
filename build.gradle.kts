plugins {
    id("java")
    id("com.gradleup.shadow") version "9.3.1"
}

group = "com.bletzzi.bletale"
version = "1.0.0"

subprojects {
    apply(plugin = "java")

    repositories {
        mavenCentral()
    }

    dependencies {
        compileOnly(files("../libs/HytaleServer.jar"))
    }
}

dependencies {
    implementation(project(":api"))
    implementation(project(":plugin"))
}