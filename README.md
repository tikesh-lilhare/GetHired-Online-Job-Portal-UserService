# GetHired-Job-Portal / User Service

---

## 📌 Overview
The User Service is one of the core microservices of the AI-Powered Job Portal. It is responsible for managing user accounts, authentication, authorization, and user-related operations.The service provides secure user registration and login using Spring Security and JWT (JSON Web Token) authentication. It also manages user roles (Job Seeker and Recruiter) and communicates with other microservices through REST APIs and Eureka Service Discovery.

---
## 🚀 Features
- User Registration
- User Login
- JWT Token Generation
- JWT Validation
- Role-Based Authorization
- BCrypt Password Encryption
- Get User Details
- Update User Information
- Delete User
- Eureka Client Registration
- REST API Development
- MySQL Database Integration
- Exception Handling
- Bean Validation

---

## 🛠 Tech Stack
## Backend
- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Spring Validation
- JWT (JSON Web Token)
- Maven
- Database
- MySQL 8+
- Service Discovery
- Netflix Eureka Client
## Build Tool
- Maven

---

## 📦 Maven Dependencies

## The project uses the following dependencies:

- Spring Boot Starter Web
- Spring Boot Starter Security
- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- Spring Boot Starter Test
- Spring Cloud Netflix Eureka Client
- MySQL Connector
- Lombok

---

## 📁 Project Structure
<img width="510" height="812" alt="Screenshot 2026-06-30 195113" src="https://github.com/user-attachments/assets/a9d6e9b6-3c51-4a1e-91e2-3e5ec4e51c82" />



---

## UserService Microservice Architecture
<img width="1536" height="1024" alt="ChatGPT Image Jul 1, 2026, 11_40_31 AM" src="https://github.com/user-attachments/assets/7a8a83c6-7371-4c95-ab8b-2430c265d11a" />


---

## 🗄 Database Configuration
## Database Name
- user_db
## Create Database
- CREATE DATABASE user_db;
## application.properties
- spring.datasource.url=jdbc:mysql://localhost:3306/user_db

- spring.datasource.username=root

- spring.datasource.password=your_password

- spring.jpa.hibernate.ddl-auto=update

- spring.jpa.show-sql=true

- spring.jpa.properties.hibernate.format_sql=true

---
## 👤 User Roles
## JOB_SEEKER
- Register
- Login
- View Jobs
- Apply Jobs

## RECRUITER
- Register
- Login
- Create Jobs
- Manage Jobs
- View Applicants

---
## 📡 REST API Endpoints
## Register User
- POST /users/register

## Request

- {
-  "fullName":"ALEX",
-  "email":"alex@gmail.com",
-  "password":"Password@123",
-  "phone":"9876543210",
-  "role":"JOB_SEEKER"
- }

## Response

- {
-  "id":1,
-  "fullName":"ALEx",
-  "email":"alex@gmail.com",
-  "role":"JOB_SEEKER"
- }

---

## Login
- POST /users/login

## Request

- {
-  "email":"alex@gmail.com",
-  "password":"Password@123"
- }

## Response

- {
-  "token":"eyJhbGciOiJIUzI1NiJ9..."
- }

---

## ▶ Running the Service
## Clone repository
- git clone https://github.com/yourusername/user-service.git
## Move into project
- cd user-service
## Build project
- mvn clean install
## Run application
- mvn spring-boot:run

---
