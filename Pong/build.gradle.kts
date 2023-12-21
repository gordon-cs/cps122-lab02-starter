plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
}

application {
    mainClass.set("pong.internal.Pong")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}