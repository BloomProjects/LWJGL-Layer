dependencies {
    runtimeOnly("org.lwjgl:lwjgl::natives-windows") {
        exclude(group = "org.lwjgl")
    }
    runtimeOnly("org.lwjgl:lwjgl-glfw::natives-windows")
    runtimeOnly("org.lwjgl:lwjgl-openal::natives-windows")
    runtimeOnly("org.lwjgl:lwjgl-opengl::natives-windows")
}
