# User Management System

This is a simple User Management System built with Java Spring Boot. It provides a RESTful API for managing user data, including creating, reading, updating, and deleting users.

## Features

- Create a new user
- Read user information by ID
- Read all users, sorted by last name and date of birth
- Search for users by name
- Update user information
- Delete a user by ID

## Used Technologies

- Java
- Spring Boot
- XAMPP (for MySQL)
- Maven

## Used Framework

- IntelliJ IDEA

## API Endpoints

### User Endpoints

- **Get all users:**

    ```http
    GET /show
    ```

- **Get user by ID:**

    ```http
    GET /show/{id}
    ```

- **Search users by name:**

    ```http
    GET /users/search?query={name}
    ```

- **Create a new user:**

    ```http
    POST /new-user
    Content-Type: application/json

    {
        "firstName": "John",
        "lastName": "Doe",
        "dateOfBirth": "1990-01-01",
        "phoneNumber": "+123456789",
        "email": "john.doe@example.com"
    }
    ```

- **Update user information:**

    ```http
    PUT /update-user/{id}
    Content-Type: application/json

    {
        "firstName": "Jane",
        "lastName": "Doe",
        "dateOfBirth": "1990-01-01",
        "phoneNumber": "+123456789",
        "email": "jane.doe@example.com"
    }
    ```

- **Delete a user:**

    ```http
    DELETE /delete-user/{id}
    ```
