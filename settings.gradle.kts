rootProject.name = "LWJGL-Layer"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}


include("common")
include("natives-windows-arm64")
include("natives-windows-x64")
include("natives-windows-x86")
include("natives-linux-arm64")
include("natives-linux-x64")
include("natives-linux-arm32")
include("natives-macos-arm64")
include("natives-macos-x64")


