FROM openjdk:16-alpine3.13 as builder
WORKDIR /usr/local/builder

COPY gradle/ ./gradle/
COPY gradle.* *.gradle.kts gradlew gradlew.bat ./
RUN ./gradlew tasks

COPY application/*/build.gradle.kts ./application/
RUN ./gradlew build || return 0

COPY . .
RUN ./gradlew shadowJar

FROM openjdk:16-alpine3.13
WORKDIR /usr/local/splike/user

COPY --from=builder /usr/local/builder/application/infrastructure/build/libs/infrastructure.jar splike-user.jar
# COPY --from=builder /usr/local/builder/build/libs/splike-user.jar .

ENTRYPOINT java $JAVA_OPTS -jar splike-user.jar
