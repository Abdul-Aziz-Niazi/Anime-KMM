plugins {
    id("com.android.application")
    kotlin("android")
    id ("kotlinx-serialization")
    id ("com.google.devtools.ksp") version "1.8.0-1.0.9"
}

android {
    namespace = "com.abdulaziz.animekmm.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.abdulaziz.animekmm.android"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.3.1")
    implementation("androidx.compose.ui:ui-tooling:1.3.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.1")
    implementation("androidx.compose.foundation:foundation:1.3.1")
    implementation("androidx.compose.material:material:1.3.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("androidx.compose.runtime:runtime-livedata:1.3.1")

    implementation("com.google.accompanist:accompanist-pager:0.25.0") // Pager
    implementation("com.google.accompanist:accompanist-pager-indicators:0.25.0")



    //Navigation
    implementation ("io.github.raamcosta.compose-destinations:core:1.7.21-beta")
    ksp ("io.github.raamcosta.compose-destinations:ksp:1.7.21-beta")

    //Parser
    implementation ("com.google.code.gson:gson:2.10.1")


    //Network
    implementation ("io.ktor:ktor-client-core:2.2.3")
    implementation("io.ktor:ktor-client-logging:2.2.3")
    implementation ("io.ktor:ktor-client-content-negotiation:2.2.3")
    implementation ("io.ktor:ktor-client-serialization:2.2.3")
    implementation("io.ktor:ktor-client-okhttp:2.2.3")
    implementation ("io.ktor:ktor-serialization-kotlinx-json:2.2.3")

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    implementation("io.coil-kt:coil-compose:2.2.2")
    implementation("io.coil-kt:coil-gif:2.2.2")
    implementation ("com.airbnb.android:lottie-compose:6.0.0")
    implementation("io.coil-kt:coil-compose:2.2.2")

}