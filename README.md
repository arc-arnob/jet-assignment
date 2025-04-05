# 🍽️ Restaurant Finder
---
[![Build](https://github.com/arc-arnob/jet-assignment/actions/workflows/ci.yml/badge.svg)](https://github.com/arc-arnob/jet-assignment/actions)
![Docker Pulls](https://img.shields.io/docker/pulls/arc007arnob/restaurant-finder?label=Docker%20Pulls&style=flat-square)
[![CodeQL](https://github.com/arc-arnob/jet-assignment/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/arc-arnob/jet-assignment/security/code-scanning)

---
A clean, modern Spring Boot web app that allows users to find the top 10 restaurants by UK postcode.  
Built with **Clean Architecture**, **SOLID principles**, **Thymeleaf UI**, and fully Dockerized for production-readiness.
---

## Features

- Search first 10 restaurants by postcode
- Beautiful UI with TailwindCSS + Thymeleaf
- Clickable embedded Google Maps
- REST API + optional Swagger docs
- Docker-ready 
---

## Software Principles Applied

### [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- **Domain Layer**: Pure business logic & model (`Restaurant`)
- **Use Case Layer**: Application logic (`RestaurantService`)
- **Infrastructure Layer**: API client for Just Eat API (`RestaurantApiClient`)
- **Presentation Layer**: REST + Thymeleaf controllers

### [SOLID Principles](https://www.baeldung.com/solid-principles)
- **S**ingle Responsibility: Layers and classes have clear roles
- **O**pen/Closed: Easy to add new data sources without modifying existing logic
- **L**iskov Substitution: Swap/mock `RestaurantDataProvider` in tests
- **I**nterface Segregation: Small, focused domain interfaces
- **D**ependency Inversion: Use case depends on abstraction, not API client

---
## Project Structure

```
restaurant-finder/
├── controller/            # REST + Thymeleaf controllers
├── usecase/               # Business logic layer
├── domain/                # Core domain model & interfaces
├── infrastructure/        # API call logic (Just Eat)
├── config/                # WebClient config
├── templates/             # Thymeleaf views (HTML)
├── Dockerfile             # For containerization
├── build.gradle           # Gradle config
└── README.md              # This file
```

## How to Run

### Option 1: Run with Spring Boot

```bash
./gradlew bootRun
```

Then open: [http://localhost:8080](http://localhost:8080)

---

### Option 2: Run with Docker (recommended)

```bash
docker run -p 8080:8080 arc007arnob/restaurant-finder
```

> No need for Java or setup — just pull and run.

---


## How to Test

```bash
./gradlew test
```

Includes:
- Unit tests for business logic
- Mockito usage for data provider mocking

---

## API Endpoint (Optional)

| Method | Endpoint             | Description            |
|--------|----------------------|------------------------|
| GET    | `/restaurants`       | Get top 10 restaurants |
| GET    | `/view?postcode=...` | Web UI for postcode search |

Swagger UI (if enabled): [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---
## CI/CD

This project includes a GitHub Actions workflow that:

- Builds the project with Gradle
- Runs unit tests
- Builds and pushes a Docker image to Docker Hub (`arc007arnob/restaurant-finder`)

See `.github/workflows/ci.yml` for the pipeline config.

---

## Assumuptions

- **Consistent API Response:**
  - It is assumed that the Just Eat API consistently returns complete and valid data for each request. This includes essential fields such as restaurant name, rating, cuisines, and address.
- **Abstracted Data Source:**
  - Since the data source may evolve over time (e.g., switching from Just Eat to a different provider), the system is designed with Dependency Injection to ensure flexibility and ease of integration with new data providers.
- **Backend-Centric Architecture:**
  - The responsibility of processing, validating, and preparing data for display lies with the backend. This assumption enables a clean separation of concerns and ensures that the frontend remains lightweight, relying on the backend to provide robust and reliable data structures for frontend.


---

## Possible Improvements

- Add exception handling
- Add client-side interactivity (Vue)
- Add caching layer (e.g., Redis)
- Add Database Support

---
## Author

Made by  [Arnob Chowdhury](https://github.com/arc-arnob)

## AI Tools Used

- [GitHub Copilot](https://github.com/features/copilot) for autocompletion and boilerplate generation
- [ChatGPT](https://chat.openai.com/) for debugging and UI suggestions
