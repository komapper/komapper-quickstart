import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    id("com.google.devtools.ksp") version "1.9.23-1.0.20"
    kotlin("jvm") version "1.9.23"
}

application {
    mainClass.set("org.komapper.quickstart.ApplicationKt")
}

dependencies {
    val komapperVersion = "1.17.1"
    platform("org.komapper:komapper-platform:$komapperVersion").let {
        implementation(it)
        ksp(it)
    }
    implementation("org.komapper:komapper-starter-jdbc")
    implementation("org.komapper:komapper-dialect-h2-jdbc")
    ksp("org.komapper:komapper-processor")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")
}

repositories {
    mavenCentral()
    mavenLocal()
}

tasks {
    withType<Test>().configureEach {
        useJUnitPlatform()
    }

    withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "11"
    }
}
