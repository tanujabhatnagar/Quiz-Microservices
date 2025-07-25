
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

### 4. Quiz Service
- Endpoint: `/quiz`
- Features:
  - Create quiz using questions from `questionservice`
  - Submit answers and get results
- URL: `http://localhost:8090`

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

