# Dream Builds - Backend API (Phase 3: Database Integration) 🚀

Welcome to the third phase of the **Dream Builds** application backend, developed as part of the Full Stack Internship at DecodeLabs. This phase focuses on "Data Longevity" by integrating a persistent relational database while maintaining strict architectural integrity.

## 🎯 Project Objective
To engineer a secure and reliable data persistence layer by bridging the backend application logic with a MySQL database, utilizing pure RESTful principles and Object-Relational Mapping (ORM).

## ⚙️ Tech Stack
* **Language:** Java
* **Framework:** Spring Boot 3
* **ORM Layer:** Spring Data JPA / Hibernate
* **Database:** MySQL
* **Tools:** Maven, Postman

## 💡 Key Features & Architectural Principles Implemented
* **Object-Relational Mapping (ORM):** Replaced raw SQL with Spring Data JPA for seamless, boilerplate-free translation between Java objects and database rows.
* **Full CRUD Operations:** Accurately mapped HTTP methods (`GET`, `POST`, `PUT`, `DELETE`) to their respective SQL actions (`SELECT`, `INSERT`, `UPDATE`, `DELETE`).
* **Autonomic Defense (Security):** Completely neutralized SQL Injection vulnerabilities by utilizing Parameterized Queries natively through JPA.
* **Data Integrity:** Enforced strict schema-level constraints (`NOT NULL`, Auto-incrementing IDs) to ensure the database remains the final, reliable source of truth.
* **The Gatekeeper Rule:** Maintained robust Syntactic and Semantic validation at the DTO layer before any data reaches the persistence layer.

## 🚀 How to Run Locally
1. Clone this repository.
2. Create a MySQL database named `dreambuilds`.
3. Rename `application.properties.example` to `application.properties` and add your MySQL username and password.
4. Run the Spring Boot application. (The database schema will automatically generate).
5. Test the API endpoints (`/projects`) using Postman.
