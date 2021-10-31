repositories {
    mavenCentral()
}

plugins {
    `java-library`

    kotlin("jvm") version "1.5.31" apply false

    id("com.github.johnrengelman.shadow") version "7.1.0" apply false
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0" apply false
}

dependencies {
    implementation(project(":application:access"))
    implementation(project(":application:domain"))
    implementation(project(":application:infrastructure"))
    implementation(project(":application:presentation"))
    implementation(project(":application:usecase"))
}

allprojects {
    val theGroup: String by rootProject
    val theVersion: String by rootProject
    val kotlinCoroutineVersion: String by rootProject
    val logbackVersion: String by rootProject

    group = theGroup
    version = theVersion

    apply(plugin = "java")
    apply(plugin = "kotlin")

    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "com.github.johnrengelman.shadow")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutineVersion")
        implementation("ch.qos.logback:logback-classic:$logbackVersion")
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(16))
//        toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    }

    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = "16"
//            jvmTarget = "17"
            }
        }

        withType<JavaExec> {
            systemProperty("user.timezone", "Asia/Tokyo")
            environment["DB_JDBC_MASTER_URL"] = "http://127.0.0.1:3306/user"
            environment["DB_JDBC_SLAVE_URL"] = "http://127.0.0.1:3306/user"
            environment["DB_USER_NAME"] = "user"
            environment["DB_USER_PASSWORD"] = "password"
        }

        withType<Test> {
            systemProperty("user.timezone", "Asia/Tokyo")
            environment["DB_JDBC_MASTER_URL"] = "http://127.0.0.1:13306/user"
            environment["DB_JDBC_SLAVE_URL"] = "http://127.0.0.1:13306/user"
            environment["DB_USER_NAME"] = "user"
            environment["DB_USER_PASSWORD"] = "password"
        }

        withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
            archiveClassifier.set("")
            archiveVersion.set("")
        }
    }
}

tasks {
    val dockerRunMySQL by creating(Exec::class) {
        group = "docker"
        commandLine("docker")
        args(
            "run",
            "--rm",
            "--name", "splike-user-mysql",
            "-e", "MYSQL_ALLOW_EMPTY_PASSWORD=yes",
            "-e", "MYSQL_DATABASE=user",
            "-p", "3306:3306",
            "-v", "${System.getProperty("user.dir")}/docker/mysql/conf.d/my.cnf:/etc/mysql/conf.d/my.cnf",
            "-d", "mysql:8.0.27"
        )
    }

    val dockerStopMySQL by creating(Exec::class) {
        group = "docker"
        commandLine("docker")
        args("stop", "splike-user-mysql")
    }

    val dockerRun by creating() {
        group = "docker"
        dependsOn("dockerRunMySQL")
    }

    val dockerStop by creating() {
        group = "docker"
        dependsOn("dockerStopMySQL")
    }
}
