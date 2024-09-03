rootProject.name = "CoreCraft"

include("velocity", "common", "fabric", "paper", "api")

pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/") {
            name = "Fabric"
        }

        gradlePluginPortal()
        mavenCentral()
    }
}