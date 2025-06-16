dependencies {
    runtimeOnly("org.lwjgl:lwjgl::natives-macos") {
        exclude(group = "org.lwjgl")
    }
    runtimeOnly("org.lwjgl:lwjgl-glfw::natives-macos")
    runtimeOnly("org.lwjgl:lwjgl-openal::natives-macos")
    runtimeOnly("org.lwjgl:lwjgl-opengl::natives-macos")
}
