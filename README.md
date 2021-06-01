[![Build Status](https://travis-ci.org/claudioaltamura/quarkus-helloworld.svg?branch=master)](https://travis-ci.org/claudioaltamura/quarkus-helloworld)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)


# quarkus-helloworld project

## Running the application in dev mode

```shell script
./mvnw compile quarkus:dev
```
## Packaging and running the application

```shell script
./mvnw package
```
If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```
The application is now runnable using `java -jar target/quarkus-helloworld-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-helloworld-1.0.0-SNAPSHOT-runner`
