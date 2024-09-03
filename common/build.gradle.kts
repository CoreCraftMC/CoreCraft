plugins {
    alias(libs.plugins.shadow)

    `java-plugin`
}

dependencies {
    compileOnly(libs.adventureMiniMessage)
    compileOnly(libs.adventureLogger)
    compileOnly(libs.adventureApi)
}