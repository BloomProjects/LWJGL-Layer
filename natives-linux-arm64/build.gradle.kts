dependencies {
    runtimeOnly("org.lwjgl:lwjgl::natives-linux-arm64") {
        exclude(group = "org.lwjgl")
    }
    runtimeOnly("org.lwjgl:lwjgl-glfw::natives-linux-arm64")
    runtimeOnly("org.lwjgl:lwjgl-openal::natives-linux-arm64")
    runtimeOnly("org.lwjgl:lwjgl-opengl::natives-linux-arm64")
}
