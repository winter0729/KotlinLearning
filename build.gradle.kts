plugins {
    java
    kotlin("jvm") version "1.4.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.12")
    implementation("net.dv8tion:JDA:4.2.0_192")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("no.tornado:tornadofx:1.7.20")
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("com.konghq:unirest-java:3.7.04")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}