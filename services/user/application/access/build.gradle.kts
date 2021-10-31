val exposedVersion: String by rootProject
val mysqlConnectorVersion: String by rootProject

dependencies {
    implementation(project(":application:domain"))
    implementation(project(":application:usecase"))

    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")

    implementation("mysql:mysql-connector-java:$mysqlConnectorVersion")
}
