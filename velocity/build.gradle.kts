plugins {
    `velocity-plugin`
}

dependencies {
    annotationProcessor(libs.velocity)
    compileOnly(libs.velocity)

    implementation(project(":common"))
}