dependencies {
    runtimeOnly("org.lwjgl:lwjgl::natives-linux-riscv64") {
        exclude(group = "org.lwjgl")
    }
    runtimeOnly("org.lwjgl:lwjgl-glfw::natives-linux-riscv64")
    runtimeOnly("org.lwjgl:lwjgl-openal::natives-linux-riscv64")
    runtimeOnly("org.lwjgl:lwjgl-opengl::natives-linux-riscv64")
}
