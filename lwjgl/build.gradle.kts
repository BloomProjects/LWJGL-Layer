dependencies {
	implementation("org.lwjgl:lwjgl")
	implementation("org.lwjgl:lwjgl-glfw")
	implementation("org.lwjgl:lwjgl-openal")
	implementation("org.lwjgl:lwjgl-opengl")
}

tasks {
	shadowJar {
		archiveFileName.set("${rootProject.name}-${rootProject.version}.jar")
		archiveClassifier.set(classifier)
	}
}