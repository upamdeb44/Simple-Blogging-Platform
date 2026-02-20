# Simple Blogging Platform API

A robust RESTful API for a blogging platform built with **Spring Boot** and **Java**. This project demonstrates core backend development concepts including CRUD operations, relational database mapping, user authentication, and API documentation.

## 🚀 Features

* **Post Management:** Create, Read, Update, and Delete blog posts.
* **Comment System:** Users can add comments to specific posts (One-to-Many relationship).
* **User Authentication:** Secure user registration with **BCrypt** password hashing via **Spring Security**.
* **Role-Based Access Control (RBAC):** Differentiates between standard `ROLE_USER` and `ROLE_ADMIN`. (e.g., Only Admins can delete posts).
* **Global Exception Handling:** Clean, meaningful JSON error responses using `@ControllerAdvice` (e.g., handling "Post Not Found" gracefully).
* **Interactive API Documentation:** Integrated **Swagger UI** for easy endpoint testing and exploration.

## 🛠️ Tech Stack

* **Java 17+**
* **Spring Boot** (Web, Data JPA, Security)
* **MySQL** (Relational Database)
* **Lombok** (Boilerplate code reduction)
* **Springdoc OpenAPI / Swagger UI** (Documentation)
* **Maven** (Dependency Management)

## ⚙️ Setup & Installation

1. Clone the repository:
   `git clone https://github.com/upamdeb44/Simple-Blogging-Platform.git`
2. Update the `src/main/resources/application.properties` file with your local MySQL credentials.
3. Run the application via your IDE or using Maven:
   `mvn spring-boot:run`
4. Access the Swagger UI documentation at:
   `http://localhost:8080/swagger-ui/index.html`

## 🔒 Security Endpoints

* `POST /api/users/register`: Public access for creating a new user account.
* `POST /api/posts`: Requires Basic Auth.
* `DELETE /api/posts/{id}`: Requires Basic Auth AND `ROLE_ADMIN` authority.