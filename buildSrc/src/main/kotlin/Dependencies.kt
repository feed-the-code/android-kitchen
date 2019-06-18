object Jetpack {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val annotation = "androidx.annotation:annotation:${Versions.annotation}"

    private object Versions {
        const val annotation = "1.1.0"
        const val core = "1.1.0-rc01"
        const val appCompat = "1.1.0-beta01"
        const val fragment = "1.1.0-beta01"
        const val lifecycle = "2.2.0-alpha01"
        const val recyclerView = "1.0.0"
    }
}

object Design {
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    private object Versions {
        const val material = "1.0.0"
        const val constraintLayout = "1.1.3"
    }
}

object Kotlin {
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
    const val reflection = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"

    private object Versions {
        const val kotlin = "1.3.31"
        const val kotlinCoroutines = "1.1.1"
    }
}

object Network {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val serializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.converter}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    private object Versions {
        const val retrofit = "2.6.0"
        const val okHttp = "3.14.2"
        const val converter = "0.4.0"
    }
}

object DI {
    const val koin = "org.koin:koin-core:${Versions.koin}"
    const val koinViewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    private object Versions {
        const val koin = "2.0.1"
    }
}

object Testing {
    const val jUnit = "org.junit.jupiter:junit-jupiter:${Versions.jUnit}"
    const val androidRunner = "androidx.test:runner:${Versions.runner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val spek = "org.spekframework.spek2:spek-dsl-jvm:${Versions.spek}"
    const val spekRunner = "org.spekframework.spek2:spek-runner-junit5:${Versions.spek}"

    private object Versions {
        const val jUnit = "5.4.2"
        const val runner = "1.2.0"
        const val espressoCore = "3.2.0"
        const val spek = "2.0.5"
    }
}