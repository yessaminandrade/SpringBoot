# 🛒 Order Management System – Challenge 5

## 📘 Project Overview
This project is a **Spring Boot 3.0 web application** developed as part of the **TechnoReady Challenge 5**, aimed at enhancing an online retail company's order management system.  
The goal was to design, implement, and secure a robust **Order Management API** with database integration, environment configuration, and automated testing.

---

## 🧩 Architecture
The application follows a **layered architecture**:

```

src/
└── main/
├── java/
│   ├── com.company.orders/       → main application package
│   │   ├── config/               → App and web configuration (YAML, profiles)
│   │   ├── controller/           → REST endpoints
│   │   ├── domain/               → Domain entities (Order)
│   │   ├── model/                → Enumerations and data models (OrderStatus)
│   │   ├── repository/           → JPA repository interface
│   │   ├── security/             → Security configuration
│   │   ├── service/              → Business logic and service layer
│   │   └── OrderManagementApplication.java
│
├── resources/
│   ├── application.yml           → Default configuration
│   ├── application-dev.yml       → Development profile
│   └── application-prod.yml      → Production profile
│
└── test/
└── java/
└── OrderServiceImplTest  → Unit tests for service layer

````

---

## 🚀 Sprint Deliverables

### **Sprint 1: Core Application Setup**
- Created a new **Spring Boot 3.0** project using **Java 17**.
- Implemented the base structure with packages for domain, controller, repository, and service.
- Integrated **H2** and **PostgreSQL** databases with JPA/Hibernate.
- Added an example REST endpoint for order creation and retrieval.
- Configured Maven, Git, and GitHub repository.

### **Sprint 2: Configuration & Security**
- Implemented **environment profiles** (`dev`, `prod`) with YAML configuration files.  
- Added `AppProperties` and `WebConfig` for property management.  
- Created **SecurityConfig** to allow all requests in development and restrict endpoints in production.
- Enabled **Actuator** for health checks and monitoring.
- Added **Swagger UI (springdoc-openapi)** for interactive API documentation.

### **Sprint 3: Testing & Documentation**
- Implemented **unit tests** using **JUnit 5** and **Mockito**.
- Created `OrderServiceImplTest` to validate CRUD operations and property constraints.
- Verified integration with the `OrderRepository`.
- Documented API behavior and completed the project setup for final submission.

---

## 🧠 Key Features
- **RESTful API** for order management (`/api/orders`).
- **CRUD operations** for `Order` entities.
- **Validation** for business rules (e.g., maximum item limits).
- **Environment-based configuration** (`application-dev.yml` / `application-prod.yml`).
- **Swagger UI** for interactive documentation.
- **Spring Security** configuration for protected routes.
- **Unit tests** for service logic using JUnit 5 and Mockito.

---

## 🧪 Technologies Used
| Layer | Technology |
|:------|:------------|
| Framework | Spring Boot 3.0 |
| Language | Java 17 |
| Database | H2 (dev), PostgreSQL (prod) |
| ORM | Spring Data JPA / Hibernate |
| API Docs | Swagger UI (springdoc-openapi) |
| Security | Spring Security |
| Testing | JUnit 5, Mockito |
| Build Tool | Maven |

---

## ⚙️ Running the Application

### ▶️ Development mode
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
````

### ▶️ Production mode

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

### ▶️ Run Tests

```bash
mvn test
```

Once running, open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
to explore the API via Swagger UI.

---

## 📄 Endpoints Summary

| Method   | Endpoint           | Description              |
| :------- | :----------------- | :----------------------- |
| `POST`   | `/api/orders`      | Create a new order       |
| `GET`    | `/api/orders/{id}` | Retrieve order by ID     |
| `GET`    | `/api/orders`      | List all orders          |
| `PUT`    | `/api/orders/{id}` | Update an existing order |
| `DELETE` | `/api/orders/{id}` | Delete order by ID       |

---

## 🧰 Testing Summary

All test cases for the `OrderServiceImpl` verify:

* Order creation, retrieval, update, and deletion.
* Validation of business rules (max items per order).
* Proper repository interaction.
* Error handling for missing entities.
