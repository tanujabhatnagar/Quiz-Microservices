# 🧠 Quiz Microservices Application

A microservices-based Quiz Application built using **Spring Boot**, **Spring Cloud**, and **Eureka Service Discovery**. It includes an API Gateway, Service Registry, and two core services: **Question Service** and **Quiz Service**.

## 📦 Project Structure

## 🚀 Technologies Used

- Java 17
- Spring Boot
- Spring Cloud (Eureka, OpenFeign)
- REST APIs
- Maven
- PostGres DB

## 🛠 Microservices Overview

### 1. API Gateway
- Acts as a single entry point for all client requests
- Handles routing to `questionservice` and `quiz-service`
- URL: `http://localhost:8761`

### 2. Service Registry
- Eureka server for dynamic service discovery
- URL: `http://localhost:8765`

### 3. Question Service
- Endpoint: `/question`
- Features:
  - Add new questions
  - Retrieve questions by category

#### Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET`  | `/allQuestions` | Retrieve all questions |
| `GET`  | `/category/{category}` | Get questions by category |
| `POST` | `/add` | Add a new question |

### 4. Quiz Service
- Endpoint: `/quiz`
- Features:
  - Create quiz using questions from `questionservice`
  - Submit answers and get results
- URL: `http://localhost:8090`

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/create` | Create a quiz using a category and number of questions |
| `POST` | `/submit/{id}` | Submit answers and get score |
| `GET`  | `/get/{id}` | Retrieve a quiz |

## 🔗 How to Use via API Gateway

Instead of calling services directly, use the API Gateway to access endpoints:

- **Add a question**  
  `POST http://localhost:8761/question-service/question/add`

- **Create a quiz**  
  `POST http://localhost:8761/quiz-service/quiz/create`

- **Submit quiz answers**  
  `POST http://localhost:8761/quiz-service/quiz/submit`

## 🧪 How to Run

1. Start the **Service Registry** (`service-registry`)
2. Launch **Question Service** and **Quiz Service**
3. Start the **API Gateway**
4. Access services via the gateway endpoints

## 📌 Future Enhancements

- Add database integration for persistence
- Implement authentication and authorization
- Build a frontend UI for user interaction

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you’d like to change.

## 📄 License

This project is licensed under the MIT License.

