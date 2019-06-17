import org.gradle.api.JavaVersion

object Config {
    const val kotlinVersion = "1.3.31"
    const val minSdk = 21
    const val compileSdk = 28
    const val targetSdk = 28
    val javaVersion = JavaVersion.VERSION_1_8
    const val buildTools = "28.0.3"
}