# 🧠 Quiz Microservice Application

This is a **simple quiz-based application** built using **Spring Boot Microservices**. The project was developed as a learning exercise to understand the design and implementation of distributed systems and RESTful communication between services.

---

## 🚀 Live Repo

GitHub: [quiz-Application-Microservice-Proj](https://github.com/sulemanSaiyed/quiz-Application-Microservice-Proj)

---

## 📚 Overview

This application allows users to take quizzes made up of multiple questions. It demonstrates a microservices architecture where each service has a clear, isolated responsibility.

---

## 🧩 Microservices Breakdown

| Service           | Description                                         |
|-------------------|-----------------------------------------------------|
| **User Service**  | Manages user data                                   |
| **Quiz Service**  | Handles quiz creation and retrieval                 |
| **Question Service** | Manages quiz questions                           |
| **API Gateway**   | Entry point that routes requests to appropriate services |
| **Eureka Server** | Service registry using Netflix Eureka               |

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Cloud (Eureka, Gateway)**
- **REST APIs**
- **Maven**
- **Lombok**
- **H2 In-Memory Database**

---

## 🔧 How to Run

### 1. Clone the Repository
```bash
git clone https://github.com/sulemanSaiyed/quiz-Application-Microservice-Proj.git
cd quiz-Application-Microservice-Proj
