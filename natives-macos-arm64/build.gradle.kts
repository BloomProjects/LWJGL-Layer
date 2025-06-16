dependencies {
    runtimeOnly("org.lwjgl:lwjgl::natives-macos-arm64") {
        exclude(group = "org.lwjgl")
    }
    runtimeOnly("org.lwjgl:lwjgl-glfw::natives-macos-arm64")
    runtimeOnly("org.lwjgl:lwjgl-openal::natives-macos-arm64")
    runtimeOnly("org.lwjgl:lwjgl-opengl::natives-macos-arm64")
}
