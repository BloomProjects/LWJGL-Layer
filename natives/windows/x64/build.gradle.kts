dependencies {
	implementation("org.lwjgl:lwjgl::natives-windows")
	implementation("org.lwjgl:lwjgl-glfw::natives-windows")
	implementation("org.lwjgl:lwjgl-openal::natives-windows")
	implementation("org.lwjgl:lwjgl-opengl::natives-windows")
}

tasks {
    shadowJar {
        archiveFileName.set("${rootProject.name}-${rootProject.version}-natives-windows-x64.jar")
        archiveClassifier.set(classifier)

        exclude("org/lwjgl/**")
    }
}