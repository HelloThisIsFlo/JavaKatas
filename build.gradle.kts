/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.1.1/userguide/tutorial_java_projects.html
 */

plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:31.0.1-jre")
    implementation("org.apache.commons:commons-lang3:3.12.0")

    testImplementation("org.mockito:mockito-core:4.0.0")
    testImplementation("junit:junit:4.13.2")
}

application {
    mainClassName = "katas.App"
}
