# BackEndConnect Project

## Overview

BackEndConnect is a backend application built using Java and Spring Boot. It provides authentication and authorization functionalities using JWT tokens. The project is configured with Maven for dependency management and uses a MariaDB database.

## Technologies Used

- **Java**: The primary programming language used for developing the application.
- **Spring Boot**: A framework that simplifies the development of Java applications by providing various features such as dependency injection, web MVC, and security.
- **Spring Security**: A powerful and customizable authentication and access control framework for Java applications.
- **JWT (JSON Web Tokens)**: Used for securely transmitting information between parties as a JSON object.
- **MariaDB**: An open-source relational database management system.
- **Maven**: A build automation tool used for managing project dependencies and building the project.
- **BCrypt**: A password hashing function used for securely storing passwords.

## Project Structure

- `src/main/java/com/backendconnect`: Contains the main application code.
  - `domain/user`: Contains user-related classes and services.
  - `infra/security`: Contains security configurations and services for JWT token handling.
- `src/main/resources`: Contains configuration files such as `application.properties`.

## Configuration

### Application Properties

The application properties are configured in the `application.properties` file located in the `src/main/resources` directory. Key properties include:

- `api.security.token.secret`: The secret key used for signing JWT tokens.
- `app.jwtExpirationInMs`: The expiration time for JWT tokens.

### Maven Dependencies

The project uses the following Maven dependencies:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.mariadb.jdbc</groupId>
        <artifactId>mariadb-java-client</artifactId>
        <version>3.0.5</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Running the Application

To run the application, use the following command:

```sh
mvn spring-boot:run
```

Ensure that the MariaDB database is running and properly configured in the `application.properties` file.

## Conclusion

This project demonstrates the use of Spring Boot and Spring Security for building a secure backend application with JWT-based authentication. The use of Maven simplifies dependency management and project configuration.
