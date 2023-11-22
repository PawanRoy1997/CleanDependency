import com.example.cleandependency.Configuration
import com.example.cleandependency.Dependencies

plugins {
    id("application-plugin")
}

android {
    namespace = Configuration.namespace
    compileSdk = Configuration.compileSdk

    defaultConfig {
        applicationId = Configuration.applicationId
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk
        versionCode = Configuration.versionCode
        versionName = Configuration.versionName

        testInstrumentationRunner = Configuration.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Configuration.sourceCompatibility
        targetCompatibility = Configuration.sourceCompatibility
    }
    kotlinOptions {
        jvmTarget = Configuration.sourceTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    dependencies {

        implementation(platform(Dependencies.Compose.composeBom))
        androidTestImplementation(platform(Dependencies.Compose.composeBom))

        Dependencies.Core.list.forEach(::implementation)

        // All dependencies of compose implemented via forEach loop
        Dependencies.Compose.list.forEach(::implementation)
        implementation(Dependencies.Room.room)
        ksp(Dependencies.Room.room_ksp)

        // All lifecycle dependencies in one go
        Dependencies.LifeCycle.list.forEach(::implementation)

        Dependencies.Testing.unitTest.forEach(::testImplementation)
        Dependencies.Testing.androidTest.forEach(::androidTestImplementation)
        Dependencies.Debug.list.forEach(::debugImplementation)
    }
}