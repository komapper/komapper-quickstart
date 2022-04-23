plugins {
    application
    id("com.google.devtools.ksp") version "1.6.21-1.0.5"
    kotlin("jvm") version "1.6.21"
}

application {
    mainClass.set("org.komapper.quickstart.ApplicationKt")
}

dependencies {
    val komapperVersion = "0.33.0"
    implementation("org.komapper:komapper-starter-jdbc:$komapperVersion")
    implementation("org.komapper:komapper-dialect-h2-jdbc:$komapperVersion")
    ksp("org.komapper:komapper-processor:$komapperVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(11))
    }
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
}
