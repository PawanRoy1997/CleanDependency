package com.example.cleandependency

import org.gradle.api.Plugin
import org.gradle.api.Project

class ApplicationPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Add the plugins you want to apply in the app module
        project.plugins.apply("com.android.application")
        project.plugins.apply("org.jetbrains.kotlin.android")
        project.plugins.apply("com.google.devtools.ksp")
    }
}