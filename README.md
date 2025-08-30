# rating-service
Microservice for managing hotel ratings (user, hotel, score, observations) as part of a hotel booking system.

# Rating Service ⭐

Microservice for managing hotel ratings as part of a hotel booking system.

---

## 📌 About
This service is responsible for managing hotel ratings, including:
- Rating value (numeric)
- User ID (who gave the rating)
- Hotel ID (which hotel was rated)
- Optional observations (comments)

It provides CRUD operations and stores the data in **MongoDB**.

---

## ✨ Features
- Create, read, update, and delete (CRUD) operations for ratings.
- Validation of required fields using **Bean Validation** (`@NotBlank`, `@NotNull`, etc.).
- Clean architecture with DTOs and service layer.
- Integration-ready with **User Service** and **Hotel Service**.

---

## 🛠️ Tech Stack
- **Java 21+**
- **Spring Boot 3+**
- **Spring Data MongoDB**
- **Hibernate Validator**
- **MongoDB**
- **Maven**

---

## 🚀 Endpoints (basic)
| Method | Endpoint         | Description             |
|--------|-----------------|-------------------------|
| POST   | `/ratings`      | Create a new rating     |
| GET    | `/ratings/{id}` | Get rating by ID        |
| GET    | `/ratings`      | Get all ratings         |
| PUT    | `/ratings/{id}` | Update rating details   |
| DELETE | `/ratings/{id}` | Delete a rating         |

---

## ⚡ How to Run
1. Clone the repository  
   ```bash
   git clone https://github.com/gusmunoz1221/rating-service.git
