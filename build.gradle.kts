plugins {
    application
    idea
    id("com.google.devtools.ksp") version "1.5.30-1.0.0-beta08"
    kotlin("jvm") version "1.5.30"
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
}

dependencies {
    val komapperVersion = "0.16.0"
    implementation("org.komapper:komapper-starter-jdbc:$komapperVersion")
    implementation("org.komapper:komapper-dialect-h2-jdbc:$komapperVersion")
    ksp("org.komapper:komapper-processor:$komapperVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
}

application {
    mainClass.set("org.komapper.quickstart.ApplicationKt")
}
