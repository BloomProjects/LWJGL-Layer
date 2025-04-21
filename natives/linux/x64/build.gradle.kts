dependencies {
	implementation("org.lwjgl:lwjgl::natives-linux")
	implementation("org.lwjgl:lwjgl-glfw::natives-linux")
	implementation("org.lwjgl:lwjgl-openal::natives-linux")
	implementation("org.lwjgl:lwjgl-opengl::natives-linux")
}

tasks {
    shadowJar {
        archiveFileName.set("${rootProject.name}-${rootProject.version}-natives-linux-x64.jar")
        archiveClassifier.set(classifier)

        exclude("org/lwjgl/**")
    }
}