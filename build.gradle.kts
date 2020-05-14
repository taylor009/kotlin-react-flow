
buildscript {

    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(url = "https://dl.bintray.com/kotlin/kotlin-dev")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
        maven(url = "https://dl.bintray.com/jetbrains/intellij-plugin-service")
        maven(url = "https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.72"))
        classpath(kotlin("serialization", version = "1.3.72"))
        classpath(kotlin("noarg", version = "1.3.72"))
        classpath("com.github.jengelman.gradle.plugins:shadow:5.2.0") // https://mvnrepository.com/artifact/com.github.jengelman.gradle.plugins/shadow
        classpath("com.android.tools.build:gradle:4.1.0-alpha09") //https://mvnrepository.com/artifact/com.android.tools.build/gradle?repo=google
    }
}

plugins {
    id("org.jetbrains.kotlin.js") version "1.3.72"
    kotlin("plugin.serialization") version "1.3.72"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:0.20.0")

    implementation("org.jetbrains:kotlin-react:16.13.1-pre.104-kotlin-1.3.72") // https://bintray.com/kotlin/kotlin-js-wrappers/kotlin-react
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.104-kotlin-1.3.72")
    implementation(npm("react", "16.13.1"))
    implementation(npm("react-dom", "16.13.1"))
    implementation("org.jetbrains:kotlin-styled:1.0.0-pre.104-kotlin-1.3.72") // https://bintray.com/kotlin/kotlin-js-wrappers/kotlin-styled
    implementation(npm("styled-components"))
    implementation(npm("inline-style-prefixer"))

    implementation(npm("react-flow-renderer", "1.3.2"))
}

kotlin.target.browser { }