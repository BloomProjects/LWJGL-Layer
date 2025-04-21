dependencies {
	implementation("org.lwjgl:lwjgl::natives-windows-arm64")
	implementation("org.lwjgl:lwjgl-glfw::natives-windows-arm64")
	implementation("org.lwjgl:lwjgl-openal::natives-windows-arm64")
	implementation("org.lwjgl:lwjgl-opengl::natives-windows-arm64")
}

tasks {
    shadowJar {
        archiveFileName.set("${rootProject.name}-${rootProject.version}-natives-windows-arm64.jar")
        archiveClassifier.set(classifier)
        exclude("org/lwjgl/**")
    }
}