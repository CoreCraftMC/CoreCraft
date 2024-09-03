plugins {
    //alias(libs.plugins.shadow)
    alias(libs.plugins.loom)

    `java-plugin`
}

project.version = "1.0.0"

base {
    archivesName = "CoreCraft"
}

loom {
    splitEnvironmentSourceSets()
}

dependencies {
    minecraft(libs.minecraft)

    mappings(loom.officialMojangMappings())

    modImplementation(libs.fabric.loader)

    modImplementation(libs.fabric.api)

    implementation(libs.vital.common)

    api(project(":common"))
}

tasks {
    processResources {
        inputs.properties("minecraft_version" to libs.versions.minecraft)
        inputs.properties("loader_version" to libs.versions.loader)
        inputs.properties("description" to rootProject.description)
        inputs.properties("version" to project.version)

        filteringCharset = "UTF-8"

        filesMatching("fabric.mod.json") {
            expand(inputs.properties)
        }
    }

    jar {
        from("LICENSE") {
            rename { "${it}_${rootProject.name}" }
        }
    }

    /*shadowJar {
        archiveBaseName.set(rootProject.name)
        archiveClassifier.set("")

        /*listOf(
            "com.ryderbelserion.vital"
        ).forEach {
            relocate(it, "libs.$it")
        }*/
    }*/
}