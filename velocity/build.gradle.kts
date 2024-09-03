plugins {
    alias(libs.plugins.runVelocity)
    alias(libs.plugins.shadow)

    `velocity-plugin`
}

project.version = "1.0.0"

dependencies {
    annotationProcessor(libs.velocity)
    compileOnly(libs.velocity)

    implementation(libs.vital.velocity)

    implementation(project(":common"))
}

tasks {
    runVelocity {
        jvmArgs("-Dnet.kyori.ansi.colorLevel=truecolor")

        defaultCharacterEncoding = Charsets.UTF_8.name()

        velocityVersion(libs.versions.velocity.get())
    }
}