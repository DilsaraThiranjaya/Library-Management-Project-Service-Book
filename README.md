# Services: Book Service

This repository contains the Spring Boot Book Service microservice for the Library Management System.

## Architectural Purpose

This service is responsible for managing the domain lifecycle of Books. It utilizes a fully multi-layered architecture:
-   **Controllers:** Expose standard REST endpoints (`/api/books`).
-   **Services:** Handle business logic and mapping.
-   **Repositories:** Spring Data JPA interface for MySQL operations.
-   **DTOs / Mappers:** MapStruct dynamically converts entities to transfer objects.
-   **Aspects:** Centralized AspectJ AOP logging.
-   **Exceptions:** Global `@RestControllerAdvice` handling custom domain runtime errors.

## Technical Stack

-   **Java**: 25
-   **Spring Boot**: 4.0.3
-   **Spring Cloud**: 2025.1.0 (Eureka / Config)
-   **Database**: MySQL (`mysql-connector-j`)
-   **Utilities**: MapStruct (1.6.3), Lombok, Spring Validation

## Configuration

It pulls configurations actively from the Config Server running on `config.platform:9000` (resolvable to `localhost:8888` locally). It automatically attempts to bind to Eureka at `http://localhost:8761/eureka/`.

## Running Locally

Because this service demands a MySQL database on port 3306, you can easily spin one up via Docker if you don't have MySQL installed gracefully on your host machine.

### 1. Start MySQL via Docker

Run the following command to temporarily start a detached MySQL instance matching the explicit application properties.

```bash
docker run -d \
  -p 3306:3306 \
  --name library-mysql \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=librarydb \
  mysql:latest
```

### 2. Compile & Run Application

Ensure you execute a `clean compile` whenever MapStruct or Lombok domains are altered so annotations are processed properly into the `target` directory.

```bash
mvn clean compile
mvn spring-boot:run
```