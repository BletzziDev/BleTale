plugins {
    id("java")
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