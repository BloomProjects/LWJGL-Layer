dependencies {
    runtimeOnly("org.lwjgl:lwjgl::natives-linux") {
        exclude(group = "org.lwjgl")
    }
    runtimeOnly("org.lwjgl:lwjgl-glfw::natives-linux")
    runtimeOnly("org.lwjgl:lwjgl-openal::natives-linux")
    runtimeOnly("org.lwjgl:lwjgl-opengl::natives-linux")
}
