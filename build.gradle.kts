plugins {
    id("com.android.application") version "8.7.0"
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "br.com.minhaia.local"
    compileSdk = 35

    defaultConfig {
        applicationId = "br.com.minhaia.local"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0-local"
    }

    buildFeatures { compose = true }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
}

dependencies {
    implementation(platform("androidx.compose:compose-bom:2024.12.01"))
    implementation("androidx.activity:activity-compose:1.10.0")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
    implementation("com.google.ai.edge.litertlm:litertlm-android:latest.release")
    implementation("org.jsoup:jsoup:1.18.3")
    debugImplementation("androidx.compose.ui:ui-tooling")
}
