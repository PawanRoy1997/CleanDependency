plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("android-application"){
            id = "application-plugin"
            implementationClass = "com.example.cleandependency.ApplicationPlugin"
        }
    }
}