plugins {
    kotlin("jvm") version "1.6.0-M1"
    kotlin("plugin.serialization") version "1.6.0-M1"
    kotlin("jupyter.api") version "0.10.0-260"
    `maven-publish`
}

group = "ru.ileasile"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
}

tasks.processJupyterApiResources {
    libraryProducers = listOf(
        "ru.ileasile.tvcharts.jupyter.Integration"
    )
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
