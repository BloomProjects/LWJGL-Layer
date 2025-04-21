dependencies {
	implementation("org.lwjgl:lwjgl::natives-macos-arm64")
	implementation("org.lwjgl:lwjgl-glfw::natives-macos-arm64")
	implementation("org.lwjgl:lwjgl-openal::natives-macos-arm64")
	implementation("org.lwjgl:lwjgl-opengl::natives-macos-arm64")
}

tasks {
    shadowJar {
        archiveFileName.set("${rootProject.name}-${rootProject.version}-natives-macos-arm64.jar")
        archiveClassifier.set(classifier)
        exclude("org/lwjgl/**")
    }
}