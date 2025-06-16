dependencies {
    runtimeOnly("org.lwjgl:lwjgl::natives-linux-ppc64le") {
        exclude(group = "org.lwjgl")
    }
    runtimeOnly("org.lwjgl:lwjgl-glfw::natives-linux-ppc64le")
    runtimeOnly("org.lwjgl:lwjgl-openal::natives-linux-ppc64le")
    runtimeOnly("org.lwjgl:lwjgl-opengl::natives-linux-ppc64le")
}
