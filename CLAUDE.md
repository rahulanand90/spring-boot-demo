# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Boot 3.2.5 demo application showcasing JPA multi-table operations, Kafka integration, REST APIs with Swagger documentation, and comprehensive testing. The application uses Java 21, PostgreSQL, and includes Docker Compose setup for local development.

## Architecture

### Core Components

- **Models**: Customer and Address entities with OneToOne relationship using JPA
- **Services**: Service layer with interface-implementation pattern (CustomerService/CustomerServiceImpl, AddressService/AddressServiceImpl)
- **Controllers**: REST controllers with Swagger annotations for API documentation
- **Repository**: Spring Data JPA repositories for data access
- **Kafka**: Producer and consumer implementation for message streaming
- **Exception Handling**: Global exception handler with custom exceptions

### Package Structure

```
com.coderahul.springbootdemo/
├── controllers/     # REST controllers
├── exceptions/      # Custom exceptions and global handler
├── kafka/          # Kafka producer and consumer
├── models/         # JPA entities
├── repository/     # Spring Data JPA repositories
└── service/        # Service layer interfaces and implementations
```

## Development Commands

### Database Setup
```bash
# Start PostgreSQL with Docker Compose
docker-compose up

# Alternative: Start all services (PostgreSQL, Redis, Kafka, Kafka UI)
docker-compose -f docker-compose_bkp.yml up
```

### Application
```bash
# Run the application
./mvnw spring-boot:run

# Build the application
./mvnw clean compile

# Package the application
./mvnw clean package

# Run tests
./mvnw test

# Run specific test
./mvnw test -Dtest=CustomerRepositoryTest
```

## Key Configuration

### Database
- **Development**: PostgreSQL on localhost:5432 (dev profile)
- **Testing**: H2 in-memory database for repository tests
- Uses sequence generators for entity IDs

### Kafka
- **Bootstrap servers**: localhost:29092
- **Consumer group**: your-consumer-group-id
- **Kafka UI**: http://localhost:8090/

### Application URLs
- **Application**: http://localhost:9000
- **Swagger UI**: http://localhost:9000/swagger-ui/index.html
- **Kafka UI**: http://localhost:8090/

## Testing Strategy

- Repository tests use `@DataJpaTest` with H2 embedded database
- Tests are configured with `@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)`
- JUnit 5 Jupiter is used for testing framework

## Data Model

Customer entity has OneToOne relationship with Address entity. The dvdrental dataset is used for testing/demo data (see data/ directory).

## Profile Configuration

- **Default profile**: Uses placeholder database configuration
- **Dev profile**: Local PostgreSQL connection with Kafka configuration
- Application runs on port 9000 in dev mode