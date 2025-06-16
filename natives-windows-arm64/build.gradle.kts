dependencies {
    runtimeOnly("org.lwjgl:lwjgl::natives-windows-arm64") {
        exclude(group = "org.lwjgl")
    }
    runtimeOnly("org.lwjgl:lwjgl-glfw::natives-windows-arm64")
    runtimeOnly("org.lwjgl:lwjgl-openal::natives-windows-arm64")
    runtimeOnly("org.lwjgl:lwjgl-opengl::natives-windows-arm64")
}
