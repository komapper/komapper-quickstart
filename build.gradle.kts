import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    idea
    kotlin("jvm") version "1.5.0"
    id("com.google.devtools.ksp") version "1.5.0-1.0.0-alpha10"
}

val generatedSourcePath = "build/generated/ksp/main/kotlin"

sourceSets {
    main {
        java {
            srcDir(generatedSourcePath)
        }
    }
}

idea.module {
    generatedSourceDirs.add(file(generatedSourcePath))
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }

    withType<Test> {
        useJUnitPlatform()
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("org.komapper:komapper-starter:0.6.1")
    ksp("org.komapper:komapper-processor:0.6.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")
}

application {
    mainClass.set("org.komapper.quickstart.ApplicationKt")
}
