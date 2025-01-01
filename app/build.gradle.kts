plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "io.hextree.webviews"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.hextree.webviews"
        minSdk = 29
        targetSdk = 34
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
    packaging {
        jniLibs.useLegacyPackaging = true
    }
}

val architectures = listOf("armeabi", "armeabi-v7a", "arm64-v8a", "x86", "x86_64", "mips", "mips64", "riscv64")

tasks.register<Copy>("copyAssetsToResources") {
    architectures.forEach { arch ->
        from("$projectDir/src/main/assets") {
            into("lib/$arch") // Relative to the destination directory
        }
    }

    // Define the destination directory only once
    into("$projectDir/src/main/resources")

    doLast {
        println("Assets copied to architecture-specific resource directories.")
    }
}

// Ensure the task runs at the correct time in your build process
tasks.named("preBuild").configure {
    dependsOn("copyAssetsToResources")
}


dependencies {
    implementation(libs.flexbox)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.webkit)
    implementation(libs.browser)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}