dependencies {
	implementation("org.lwjgl:lwjgl::natives-windows-x86")
	implementation("org.lwjgl:lwjgl-glfw::natives-windows-x86")
	implementation("org.lwjgl:lwjgl-openal::natives-windows-x86")
	implementation("org.lwjgl:lwjgl-opengl::natives-windows-x86")
}

tasks {
    shadowJar {
        archiveFileName.set("${rootProject.name}-${rootProject.version}-natives-windows-x86.jar")
        archiveClassifier.set(classifier)
        exclude("org/lwjgl/**")
    }
}