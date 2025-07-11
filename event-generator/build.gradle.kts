plugins {
    kotlin("jvm") version "2.1.10"
    id("com.gradleup.shadow") version "8.3.6"
}

group = "dev.nikst"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://packages.confluent.io/maven/")
}

dependencies {
    implementation("org.apache.kafka:kafka-clients:3.6.1")
    implementation("io.confluent:kafka-avro-serializer:7.5.0")
    implementation("org.apache.avro:avro:1.11.1")
    implementation("com.google.guava:guava:32.1.3-jre")

    implementation("org.slf4j:slf4j-simple:2.0.9")

    implementation("com.opencsv:opencsv:5.9")

    testImplementation(kotlin("test"))
}

tasks.shadowJar {
    manifest {
        attributes["Main-Class"] = "dev.nikst.MainKt"
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}