dependencies {
	implementation("org.lwjgl:lwjgl::natives-linux-arm32")
	implementation("org.lwjgl:lwjgl-glfw::natives-linux-arm32")
	implementation("org.lwjgl:lwjgl-openal::natives-linux-arm32")
	implementation("org.lwjgl:lwjgl-opengl::natives-linux-arm32")
}

tasks {
    shadowJar {
        archiveFileName.set("${rootProject.name}-${rootProject.version}-natives-linux-arm32.jar")
        archiveClassifier.set(classifier)
        exclude("org/lwjgl/**")
    }
}