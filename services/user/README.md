# User Service

UserService is user control application of splike.

## Getting Started

Run com.toroponz.splike.user.infrastructure.dependency application by docker.

```shell
./gradlew dockerRun
```

Run application.

```shell
./gradlew run
```

Access to application.

```shell
curl -X GET "http://localhost:80/health"
```

After, stop com.toroponz.splike.user.infrastructure.dependency applications.

```shell
./gradlew dockerStop
```

## Testing

Run test.

```shell
./gradlew test
```

## Formatting

Check code format.

```shell
./gradlew ktlintCheck
```

Auto fix code format.

```shell
./gradlew ktlintFormat
```

## Build

Build docker image.

```shell
docker build -t splike-user .
```
