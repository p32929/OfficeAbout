plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "p32929.officeaboutapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "p32929.officeaboutapp"
        minSdk = 21
        targetSdk = 35
        versionCode = 2
        versionName = "2.0.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
}

dependencies {
    implementation(project(":officeaboutlib"))
    implementation(libs.material)
}
