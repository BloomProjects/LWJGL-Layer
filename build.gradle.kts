plugins {
	kotlin("jvm") version "1.6.10"
	id("com.github.johnrengelman.shadow") version "6.1.0"
	id("maven-publish")
}

group = "me.toidicakhia"
version = properties["lwjgl_version"] ?: "3.3.3"

allprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "com.github.johnrengelman.shadow")

	group = rootProject.group
	version = rootProject.version

	repositories {
		maven("https://jitpack.io")
		mavenCentral()
	}
}

subprojects {
	dependencies {
		implementation(platform("org.lwjgl:lwjgl-bom:$version"))
		compileOnly("org.jetbrains.kotlin:kotlin-stdlib")
	}

	tasks {
		build {
			dependsOn(shadowJar)
		}

		shadowJar {
			archiveBaseName.set(rootProject.name)
			archiveClassifier.set(project.name)
			destinationDirectory.set(rootProject.buildDir.resolve("libs"))

			if (project.name.startsWith("natives"))
				exclude("org/lwjgl/**")
		}
	}
}

publishing {
	repositories {
		maven {
			name = "BloomRepo"
			url = uri("https://repo.bloomprojects.lol/snapshots")
			credentials(PasswordCredentials::class)
			authentication {
				create<BasicAuthentication>("basic")
			}
		}
	}

	publications {
		create<MavenPublication>("shadow") {
			groupId = rootProject.group.toString()
			artifactId = rootProject.name
			version = rootProject.version.toString()
			subprojects.forEach { subproject ->
				artifact(subproject.tasks.shadowJar)
			}
		}
	}
}