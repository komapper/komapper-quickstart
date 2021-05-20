plugins {
    application
    idea
    kotlin("jvm")
    id("com.google.devtools.ksp")
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
    withType<Test> {
        useJUnitPlatform()
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    val komapperVersion: String by project
    implementation("org.komapper:komapper-starter:$komapperVersion")
    ksp("org.komapper:komapper-processor:$komapperVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
}

application {
    mainClass.set("org.komapper.quickstart.ApplicationKt")
}
