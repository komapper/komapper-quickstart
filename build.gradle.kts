import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    id("com.google.devtools.ksp") version "2.0.10-1.0.24"
    kotlin("jvm") version "2.0.10"
}

application {
    mainClass.set("org.komapper.quickstart.ApplicationKt")
}

dependencies {
    val komapperVersion = "2.2.0"
    platform("org.komapper:komapper-platform:$komapperVersion").let {
        implementation(it)
        ksp(it)
    }
    implementation("org.komapper:komapper-starter-jdbc")
    implementation("org.komapper:komapper-dialect-h2-jdbc")
    ksp("org.komapper:komapper-processor")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.0")
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
