dependencies {
	implementation("org.lwjgl:lwjgl::natives-macos")
	implementation("org.lwjgl:lwjgl-glfw::natives-macos")
	implementation("org.lwjgl:lwjgl-openal::natives-macos")
	implementation("org.lwjgl:lwjgl-opengl::natives-macos")
}

tasks {
    shadowJar {
        archiveFileName.set("${rootProject.name}-${rootProject.version}-natives-macos-x64.jar")
        archiveClassifier.set(classifier)

        exclude("org/lwjgl/**")
    }
}