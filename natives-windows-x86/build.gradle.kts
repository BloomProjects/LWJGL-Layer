dependencies {
    runtimeOnly("org.lwjgl:lwjgl::natives-windows-x86") {
        exclude(group = "org.lwjgl")
    }
    runtimeOnly("org.lwjgl:lwjgl-glfw::natives-windows-x86")
    runtimeOnly("org.lwjgl:lwjgl-openal::natives-windows-x86")
    runtimeOnly("org.lwjgl:lwjgl-opengl::natives-windows-x86")
}
