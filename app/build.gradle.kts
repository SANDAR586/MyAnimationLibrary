plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    id("androidx.room")
    id("com.google.devtools.ksp") version "2.1.21-2.0.1"

}

android {
    namespace = "com.ydnsa.koinmvi"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.ydnsa.koinmvi"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt") ,
                "proguard-rules.pro"
                         )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {

    implementation(libs.androidx.room.runtime)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.koin.androidx.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit)
    implementation(libs.moshi)
    implementation(libs.gson)
    implementation(libs.converter.moshit)
    implementation(libs.converter.gson)
    implementation("androidx.navigation3:navigation3-runtime:1.0.0-alpha01")
    implementation("androidx.navigation3:navigation3-ui:1.0.0-alpha01")
    implementation("androidx.lifecycle:lifecycle-viewmodel-navigation3:1.0.0-SNAPSHOT")
    implementation("androidx.compose.material3.adaptive:adaptive-navigation3:1.0.0-SNAPSHOT")
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.tensorflow.tensorflow.lite)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.material)
    // Task library for object detection
    implementation(libs.tensorflow.lite.task.vision)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.google.accompanist.insets)

    ksp(libs.androidx.room.compiler)

    //Glide
    implementation(libs.com.github.bumptech.glide.glide)
    annotationProcessor(libs.compiler)

    // CameraX for live camera feed
    implementation(libs.androidx.camera.camera2)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.view)
    implementation(libs.androidx.room.ktx)
    // to set the status bar theme
    // implementation (libs.accompanist.systemuicontroller) wrong version

    implementation(libs.wasabeef.richeditor.android)

    implementation(libs.coil.compose)
    implementation(libs.coil.gif)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}