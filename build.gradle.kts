plugins {
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("java")
    id("idea")
}

group = "me.toidicakhia"
version = "3.3.3"

allprojects {
    apply(plugin = "com.github.johnrengelman.shadow")
    apply(plugin = "java")

    repositories {
        maven("https://jitpack.io")
        mavenCentral()
    }

    dependencies {
        implementation(platform("org.lwjgl:lwjgl-bom:3.3.3"))
    }

    tasks {
        build {
            dependsOn(shadowJar)
        }

        shadowJar {
            mergeServiceFiles()
            destinationDirectory.set(file("${rootProject.buildDir}/libs"))
        }
    }
}