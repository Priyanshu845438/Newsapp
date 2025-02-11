plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.newsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.newsapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    // Retrofit for network calls
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    // Gson converter for JSON parsing
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    // RecyclerView
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    // CardView
    implementation ("androidx.cardview:cardview:1.0.0")
    // Coil for image loading
    implementation ("io.coil-kt:coil:2.1.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}