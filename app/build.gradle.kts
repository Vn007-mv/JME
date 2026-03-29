import java.util.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
}

android {
    namespace = "com.jme"
    compileSdk = 33
    
    defaultConfig {
        applicationId = "com.jme"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        
        // Configuração para bibliotecas nativas
        ndk {
            abiFilters.addAll(listOf("armeabi-v7a", "arm64-v8a", "x86", "x86_64"))
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
    
    // Configuração das pastas
    sourceSets {
        named("main") {
            jniLibs.srcDirs("jniLibs")
            assets.srcDirs("assets")
        }
    }
    
    // Resolve conflitos de arquivos duplicados
    packaging {
        resources {
            pickFirsts.add("**/libjbulletjme.so")
            pickFirsts.add("**/libgluegen-rt.so")
            pickFirsts.add("**/libjinput-android.so")
            pickFirsts.add("**/libopenal.so")
            excludes.add("META-INF/DEPENDENCIES")
            excludes.add("META-INF/NOTICE")
            excludes.add("META-INF/LICENSE")
            excludes.add("META-INF/LICENSE.txt")
            excludes.add("META-INF/NOTICE.txt")
        }
    }
}

dependencies {
    // Todos os JARs da pasta libs
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))
    
    // Android básico
    implementation("androidx.appcompat:appcompat:1.6.1")
}