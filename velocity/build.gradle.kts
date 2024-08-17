plugins {
    `velocity-plugin`
}

dependencies {
    annotationProcessor(libs.velocity)
    compileOnly(libs.velocity)

    implementation(libs.vital.velocity)

    implementation(project(":common"))
}