# Maker Shark Task

## Overview
This project provides a simple User Management API built with Spring Boot. It includes endpoints for user registration and fetching user details.

## Endpoints

### Register User

- **URL:** `/api/user/register`
- **Method:** `POST`
- **Request Body:**

```json
{
    "username": "string",
    "email": "string",
    "password": "string",
    "birthYear": 1900,
    "address": "string",
    "about": "string"
}
```

### Fetch User

- **URL:** `/api/user/fetch`
- **Method:** `GET`
- **Request Body:**

```json
{
    "username": "string",
    "birthYear": 1900,
    "address": "string",
    "about": "string",
    "joinedOn": "timestamp"
}
```

## Running the Project

1. Clone the repository:
    ```bash
    git clone https://github.com/pranavbisaria/makershark.git
    ```
2. Navigate to the project directory:
    ```bash
    cd makersharks
    ```
3. Build the project:
    ```bash
    ./mvnw clean install
    ```
4. Run the project:
    ```bash
    ./mvnw spring-boot:run
    ```
5. The project will be accessible at `http://localhost:8181`


6. Swagger UI will be accessible at `http://localhost:8181/swagger-ui/index.html`



