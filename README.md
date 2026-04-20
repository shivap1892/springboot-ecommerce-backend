 Spring Boot JWT Authentication Backend

 Project Overview

This project is a Spring Boot REST API that implements JWT-based authentication and authorization.

It provides secure APIs for user management and product access using token-based security.

---

 Tech Stack

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- JWT (JJWT library)
- Maven

---

 Project Structure

com.example.demo
├── config        # Security & JWT Filter
├── controller    # REST APIs
├── model         # Entity classes
├── repository    # Database layer
├── service       # Business logic
├── exception     # Global exception handling

---

 Features

- User Registration API
- User Login API
- JWT Token Generation
- Secure APIs using JWT Filter
- Token Validation (signature + expiry)
- Global Exception Handling
- Clean API response structure

---

🔄 API Flow

1️⃣ Register User
→ "/users/register"

2️⃣ Login
→ "/users/login"
→ Returns JWT Token

3️⃣ Access Protected APIs
→ Add header:

Authorization: Bearer <token>

---

 API Endpoints

🔹 Register

POST /users/register

🔹 Login

POST /users/login

🔹 Get Products (Protected)

GET /products

---

 Sample Request

Login Request

{
  "username": "shiva",
  "password": "1234"
}

Login Response

eyJhbGciOiJIUzI1NiJ9...

---

❌ Error Handling

Example:

{
  "message": "Invalid username or password",
  "status": 500
}

---

 Security Implementation

- JWT-based authentication
- Custom filter using "OncePerRequestFilter"
- Public APIs: "/users/login", "/users/register"
- Protected APIs: all others
- Token validation using secret key

---

 How to Run

1. Clone repo

git clone https://github.com/shivap1892/springboot-ecommerce-backend.git

2. Open in IntelliJ / Eclipse

3. Configure MySQL in "application.properties"

4. Run application

mvn spring-boot:run

--- 
Author

Shiva

---

 Future Enhancements

- Role-based authorization (ADMIN / USER)
- Password encryption (BCrypt)
- Swagger API documentation
- Deployment (AWS / Render)
