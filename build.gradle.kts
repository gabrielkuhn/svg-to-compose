import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    id("maven-publish")
}

group = "br.com.devsrsouza"
version = "0.6.0"

repositories {
    mavenCentral()
    maven("https://maven.google.com")
    maven("https://jetbrains.bintray.com/trove4j")
}

dependencies {
    implementation("com.google.guava:guava:23.0")
    implementation("com.android.tools:sdk-common:27.2.0-alpha16")
    implementation("com.android.tools:common:27.2.0-alpha16")
    implementation("com.squareup:kotlinpoet:1.7.2")
    implementation("org.ogce:xpp3:1.1.6")

    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["kotlin"])
        }
    }
}