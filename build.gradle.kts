/*
 * Copyright 2022 limbang and contributors.
 *
 * 此源代码的使用受 GNU AGPLv3 许可证的约束，该许可证可在"LICENSE"文件中找到。
 * Use of this source code is governed by the GNU AGPLv3 license that can be found in the "LICENSE" file.
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val version = "1.7.0"
    kotlin("jvm") version version
    kotlin("plugin.serialization") version version
}

group = "top.limbang"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.8")
    implementation("org.slf4j:slf4j-api:1.7.36")
    testImplementation(kotlin("test"))
    testImplementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.8")
    testImplementation("ch.qos.logback:logback-classic:1.2.11")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}