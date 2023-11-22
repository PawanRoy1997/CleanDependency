package com.example.cleandependency

import org.gradle.api.JavaVersion

object Configuration {
    const val namespace = "com.example.cleandependency"
    const val compileSdk = 34
    const val applicationId = "com.example.cleandependency"
    const val minSdk = 21
    const val targetSdk = 34
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    val sourceCompatibility = JavaVersion.VERSION_17
    const val sourceTarget = "17"
}