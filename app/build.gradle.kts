plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.openapp.moneymanager"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.openapp.moneymanager"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        configurations.all{
            resolutionStrategy {
                force("androidx.work:work-runtime:2.6.0")
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    implementation(Dependencies.CORE)
    implementation(Dependencies.APPCOMPAT)

    //ui
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.CONSTRAINT)

    //test
    testImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.EXT_JUNIT)
    androidTestImplementation(Dependencies.ESPRESSO_CORE)

    //mvi core
    implementation(Dependencies.MVI_CORE)
    implementation(Dependencies.MVI_BINDER)
    implementation(Dependencies.MVI_HELPER)
    implementation(Dependencies.MVI_MODEL_WATCHER)

    //firebase
    implementation(platform(Dependencies.FIREBASE_BOM))
    implementation(Dependencies.FIREBASE_CRASHLITICS)

    //coroutines
    implementation(Dependencies.COROUTINES)
    implementation(Dependencies.COROUTINES_ANDROID)
}