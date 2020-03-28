import org.gradle.api.tasks.testing.logging.TestLogEvent

group = "de.claudioaltamura.java.quarkus.helloworld"
version = "1.0.0-SNAPSHOT"

plugins {
    java
    id("io.quarkus") version "1.3.0.Final"
    id("com.diffplug.gradle.spotless") version "3.27.1"
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(enforcedPlatform("io.quarkus:quarkus-universe-bom:1.3.0.Final"))

    implementation("io.quarkus:quarkus-resteasy")
    implementation("io.quarkus:quarkus-jackson")
    implementation("io.quarkus:quarkus-resteasy-jackson")
    implementation("io.quarkus:quarkus-hibernate-validator")

    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
    testImplementation("org.mockito:mockito-junit-jupiter:3.2.4")
    testImplementation("org.assertj:assertj-core")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

spotless {
    java {
        googleJavaFormat()
    }
    kotlinGradle {
        ktlint()
    }
}

tasks {
    compileJava {
        options.compilerArgs.add("-parameters")
        options.encoding = "UTF-8"
    }

    compileTestJava {
        options.encoding = "UTF-8"
    }

    test {
        useJUnitPlatform() {
        }
        testLogging {
            events = setOf(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
        }
        testLogging.showStandardStreams = true
    }
}
