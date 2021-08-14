pluginManagement {
    val kotlinVersion: String by settings
    val kspVersion: String by settings
    repositories {
        gradlePluginPortal()
    }
    plugins {
        id("org.jetbrains.kotlin.jvm") version kotlinVersion
        id("com.google.devtools.ksp") version kspVersion
    }
}

rootProject.name = "komapper-quickstart"
