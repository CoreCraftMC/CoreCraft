plugins {
    alias(libs.plugins.shadowJar)

    `java-plugin`
}

repositories {

}

dependencies {
    implementation(libs.commons)
    implementation(libs.json)

    compileOnly(libs.adventureMiniMessage)
    compileOnly(libs.adventureLogger)
    compileOnly(libs.adventureApi)
    //compileOnly(libs.legacy)
}

tasks {
    shadowJar {
        //archiveBaseName.set(rootProject.name)
        //archiveClassifier.set("")

        listOf(
            "org.apache.commons",
            "org.json"
        ).forEach {
            relocate(it, "libs.$it")
        }
    }
}