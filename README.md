# Spring Boot CRUD Operations with MongoDB

This is a basic Spring Boot application for managing CRUD operations using MongoDB as the database. The project follows the MVC architecture and includes REST APIs to perform create, read, update, and delete operations.

## Features

- CRUD operations for managing data
- MVC architecture
- MongoDB integration
- RESTful APIs

## Prerequisites

- Java 17 or higher
- Mavn 3.6.0 or higher
- MongoDB Atlas account (or local MongoDB instance)
- Git

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-username/your-spring-boot-project.git
cd your-spring-boot-project
```

- Update your Username and Password Inside the application.yml file.
- Use the Driver Connection String present on MongoDB Atlas to connect to your cluster.
  
```bash
./mvnw clean install
./mvnw spring-boot:run
```

## REST API Endpoints

Here are the basic CRUD API endpoints:

- Create: POST /api/users
- Read: 
  - GET /api/users/{id} --> getUserById
  - GET /api/users --> getAllUsers
- Update: PUT /api/users/{id}
- Delete: DELETE /api/your-resource/{id}

## Troubleshooting
## Common Issues

- Network Access: Ensure your IP is whitelisted in MongoDB Atlas.
- SSL Issues: Ensure Java trusts the MongoDB Atlas SSL certificate.
- Configuration Errors: Verify that your .env file and application.yml are correctly set up.
