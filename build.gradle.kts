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
    `maven-publish`
    signing
}

group = "top.limbang"
version = "1.0.0"

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

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    repositories {
        maven {
            name = "OSSRH"
            val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            credentials {
                username = System.getenv("MAVEN_USERNAME")
                password = System.getenv("MAVEN_PASSWORD")
            }
        }
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/limbang/text-to-speech")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "text-to-speech"
            from(components["java"])
            pom {
                name.set("Text to speech")
                packaging = "jar"
                url.set("https://github.com/limbang/text-to-speech")
                description.set("Text-to-speech based on Azure speech service")

                scm {
                    url.set("https://github.com/limbang/text-to-speech")
                    connection.set("git@github.com:limbang/text-to-speech.git")
                    developerConnection.set("https://github.com/limbang/text-to-speech.git")
                }

                licenses {
                    license {
                        name.set("GNU Affero General Public License v3.0")
                        url.set("https://choosealicense.com/licenses/agpl-3.0/")
                    }
                }

                developers {
                    developer {
                        id.set("limbang")
                        name.set("limbang")
                        email.set("495071565@qq.com")
                    }
                }

            }
        }
    }
}

signing {
    val signingKeyId: String? by project
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)
    sign(publishing.publications["mavenJava"])
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}