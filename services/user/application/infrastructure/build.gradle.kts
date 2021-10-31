val ktorVersion: String by rootProject
val koinVersion: String by rootProject
val jacksonVersion: String by rootProject

plugins {
    application
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

dependencies {
    implementation(project(":application:access"))
    implementation(project(":application:domain"))
    implementation(project(":application:presentation"))
    implementation(project(":application:usecase"))

    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-locations:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")

    implementation("io.insert-koin:koin-ktor:$koinVersion")

    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-joda:$jacksonVersion")
}
