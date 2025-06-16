dependencies {
    runtimeOnly("org.lwjgl:lwjgl::natives-linux-arm32") {
        exclude(group = "org.lwjgl")
    }
    runtimeOnly("org.lwjgl:lwjgl-glfw::natives-linux-arm32")
    runtimeOnly("org.lwjgl:lwjgl-openal::natives-linux-arm32")
    runtimeOnly("org.lwjgl:lwjgl-opengl::natives-linux-arm32")
}