plugins {
    alias(libs.plugins.shadowJar)

    `java-plugin`
}

repositories {

}

dependencies {
    compileOnly(libs.adventureMiniMessage)
    compileOnly(libs.adventureLogger)
    compileOnly(libs.adventureApi)
    //compileOnly(libs.legacy)
}

tasks {
    shadowJar {
        //archiveBaseName.set(rootProject.name)
        //archiveClassifier.set("")
    }
}