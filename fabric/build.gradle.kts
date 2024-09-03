plugins {
    alias(libs.plugins.loom)

    `java-plugin`
}

dependencies {
    minecraft(libs.minecraft)

    mappings(loom.officialMojangMappings())

    modImplementation(libs.fabric.loader)

    modImplementation(libs.fabric.api)
}

tasks {
    processResources {
        inputs.properties("minecraft_version" to rootProject.name)
        inputs.properties("loader_version" to rootProject.version)
        inputs.properties("version" to rootProject.version)

        filesMatching("fabric.mod.json") {
            expand(inputs.properties)
        }
    }
}