import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    id("com.google.devtools.ksp") version "1.6.21-1.0.5"
    kotlin("jvm") version "1.6.21"
}

application {
    mainClass.set("org.komapper.quickstart.ApplicationKt")
}

dependencies {
    val komapperVersion = "1.1.2"
    platform("org.komapper:komapper-platform:$komapperVersion").let {
        implementation(it)
        ksp(it)
    }
    implementation("org.komapper:komapper-starter-jdbc")
    implementation("org.komapper:komapper-dialect-h2-jdbc")
    ksp("org.komapper:komapper-processor")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
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
