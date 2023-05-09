The purpose of this project is to run a Spring Boot native Docker image including an in-memory H2 database with loading
from file at startup.

Pre-requisite: Docker and GraalVM.

# Terms

A **native image** is an executable that runs without runtime (here: without JVM).

A **Docker image** is built with the `docker` CLI to run as a Docker container.

A **native Docker image** is a Docker image of a native image.

# Commands

For faster `mvn` build commands run, add `-Dmaven.test.skip=true`.

**Build a jar in /target**

`mvn install`

**Build and run the app**

`mvn spring-boot:run`

**Build a Docker image with spring-boot plugin**

`mvn spring-boot:build-image`

**Run a Docker image**

Pre-requisite: the Docker image must exist, see with `docker images`.

`docker run -p 8080:8080 [image-name]:[tag] --rm`

**Build a native image**

`mvn native:compile -Pnative`

**Run a native image**

`./target/demodockernativeh2`

**Build a native Docker image with spring-boot plugin (no Dockerfile)**

`mvn spring-boot:build-image -Pnative`

# Status

Everything works fine.

## Tools

One can inspect the file system of a container, useful to discover where the H2 DB file lies:

Create a container without running it:

`docker create --name"[container name]" [image name]`

Export the content of the file system:

`docker export [container name] | tar t`

# Test

Run the app, the database is pre-filled, so a GET to http://localhost:8080/getIndex should return HTTP 200 with _0_ in
the body.

# Ref

[Spring Boot GraalVM Native Image support](https://docs.spring.io/spring-boot/docs/current/reference/html/native-image.html)