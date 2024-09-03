plugins {
    alias(libs.plugins.shadow)

    `java-plugin`
}

repositories {
    maven("https://libraries.minecraft.net")
}

dependencies {
    compileOnly(libs.bundles.adventure)
    compileOnly(libs.brigadier)
}