# Simple Spring Boot Quiz App

Spring Boot Quiz API with JPA, DTOs, Lombok, and REST endpoints for random category quizzes and scoring.

## ✨ Features
- Create quizzes by category with random questions
- Submit answers and get a score
- JPA entity relationships between tables
- DTO-based API design
- Lombok for boilerplate reduction
- Dependency Injection / IoC
- RESTful API using `ResponseEntity`

## 🛠️ Tech Stack
- Java 26
- Spring Boot
- Spring Data JPA
- Lombok
- H2 / MySQL / PostgreSQL (configure as needed)

### Create Quiz
`POST /quiz/create`

**Body**
```json
{
  "category": "java",
  "numQ": 5,
  "title": "Java Basics"
}
```

### Get Quiz Questions
`GET /quiz/{quizId}`

### Submit Quiz
`POST /quiz/{quizId}/submit`

**Body**
```json
[
  {"answer": "A"},
  {"answer": "C"},
  {"answer": "B"}
]
```

**Response**
```json
3
```

## ⚙️ Configuration
Set your database config in `application.properties` or `application.yml`.

Example:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## ▶️ Run Locally
```bash
git clone https://github.com/MohamedNoaman705/Simple_SpringBoot_QuizApp.git
cd Simple_SpringBoot_QuizApp
./mvnw spring-boot:run
```

## ✅ Notes
- Ensure your `Answer` DTO has a no-args constructor and getters/setters for JSON binding.
- Adjust payload fields to match your DTO definitions.

## 📄 License
MIT (or add your preferred license)
