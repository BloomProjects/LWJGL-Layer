dependencies {
	implementation("org.lwjgl:lwjgl::natives-linux-arm64")
	implementation("org.lwjgl:lwjgl-glfw::natives-linux-arm64")
	implementation("org.lwjgl:lwjgl-openal::natives-linux-arm64")
	implementation("org.lwjgl:lwjgl-opengl::natives-linux-arm64")
}

tasks {
    shadowJar {
        archiveFileName.set("${rootProject.name}-${rootProject.version}-natives-linux-arm64.jar")
        archiveClassifier.set(classifier)
        exclude("org/lwjgl/**")
    }
}