plugins {
    alias(libs.plugins.shadowJar)

    `java-plugin`
}

dependencies {
    compileOnly(libs.adventureMiniMessage)
    compileOnly(libs.adventureLogger)
    compileOnly(libs.adventureApi)
}