

# Fitness Tracker Web Application

A Java-based Fitness Tracker web application developed using **Core Java, JDBC, Servlets, Maven, and Apache Tomcat**, demonstrating real-world backend development concepts, layered architecture, and database-driven web deployment.

---

## 📋 Project Overview

The **Fitness Tracker** application allows users to:
- Create fitness users
- Log workout activities
- Persist and retrieve workout data using a MySQL database

The project demonstrates an end-to-end Java web application lifecycle — from business logic and database integration to WAR packaging and deployment on Apache Tomcat.

---

## ✨ Features Implemented

### 1. Object-Oriented Programming (OOP)
- **Encapsulation**: Private fields with public getters in model classes
- **Abstraction**: DAO layer abstracts database operations
- **Inheritance**: Servlets extend `HttpServlet`
- **Polymorphism**: Service and DAO method calls via object references
- **Exception Handling**: Runtime and checked exception handling across JDBC and Servlets

---

### 2. Core Java Concepts
- Classes & Objects
- Constructors
- Packages & Access Modifiers
- UUID-based unique ID generation
- String manipulation
- Date handling using `LocalDate`
- Optional usage for safe lookups

---

### 3. Layered Architecture (MVC-like)
- **Model Layer**: `User`, `Workout`
- **DAO Layer**: `UserDAO`, `WorkoutDAO`, `DBConnection`
- **Service Layer**: `FitnessService`
- **Controller Layer**: Servlets (`CreateUserServlet`, `LogWorkoutServlet`)
- **View Layer**: HTML pages

This clear separation improves maintainability and scalability.

---

### 4. Database Operations (DAO Pattern)
- DAO pattern used for all database interactions
- Secure SQL execution using `PreparedStatement`
- Centralized database connection management
- Clean separation between business logic and persistence logic

---

### 5. JDBC & MySQL Integration
- MySQL JDBC Connector
- Connection handling via `DriverManager`
- Try-with-resources for automatic resource cleanup
- SQL INSERT and SELECT operations
- Foreign key-based relational schema

---

### 6. Servlets & Web Integration
- Servlet-based request handling using Jakarta Servlet API
- HTML form submission via GET and POST methods
- WAR packaging and deployment on Apache Tomcat 10
- Annotation-based servlet configuration (`@WebServlet`)

---

## 🏗️ Project Structure

```
Fitness-Tracker/
├── src/
│   ├── main/
│   │   ├── java/com/fitlogix/
│   │   │   ├── model/
│   │   │   │   ├── User.java
│   │   │   │   └── Workout.java
│   │   │   ├── dao/
│   │   │   │   ├── DataStore.java
│   │   │   │   └── jdbc/
│   │   │   │       ├── DBConnection.java
│   │   │   │       ├── UserDAO.java
│   │   │   │       └── WorkoutDAO.java
│   │   │   ├── service/
│   │   │   │   └── FitnessService.java
│   │   │   ├── servlet/
│   │   │   │   ├── CreateUserServlet.java
│   │   │   │   └── LogWorkoutServlet.java
│   │   │   └── ui/ (Deprecated Console UI)
│   │   └── webapp/
│   │       ├── index.html
│   │       ├── createUser.html
│   │       ├── logWorkout.html
│   │       └── viewWorkouts.html
├── target/
├── pom.xml
├── .gitignore
└── README.md
```

---

## 🚀 Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Apache Tomcat 10+

---

### Database Setup

```sql
CREATE DATABASE fitness_db;
USE fitness_db;

CREATE TABLE users (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    age INT
);

CREATE TABLE workouts (
    id VARCHAR(20) PRIMARY KEY,
    user_id VARCHAR(20),
    type VARCHAR(100),
    duration INT,
    date DATE
);
```

---

### Configure Database Connection

Update credentials in `DBConnection.java`:

```java
jdbc:mysql://localhost:3306/fitness_db
USER: root
PASSWORD: root
```

> Note: Credentials are for local development and academic use only.

---

### Build & Deploy

```bash
mvn clean package
cp target/fit-logix.war $CATALINA_HOME/webapps/
$CATALINA_HOME/bin/startup.sh
```

Access the application:
```
http://localhost:8080/fit-logix/
```

---

## 🧪 Testing

### Manual Testing
1. Open the homepage
2. Create a new user
3. Log a workout for the user
4. Verify records in MySQL database

---

## 📊 Key Classes & Responsibilities

| Class | Responsibility |
|------|----------------|
| User | Represents a fitness user |
| Workout | Represents a workout activity |
| FitnessService | Business logic layer |
| UserDAO | User database operations |
| WorkoutDAO | Workout database operations |
| DBConnection | JDBC connection management |
| Servlets | HTTP request handling |

---

## 🔒 Best Practices & Security
- Prepared Statements prevent SQL injection
- Layered architecture for clean separation of concerns
- Centralized DB connection handling
- `.gitignore` used to avoid committing build artifacts

---

## 📝 Notes
- Project supports both JSON-based storage (Review-1) and JDBC-based storage (Review-2)
- Console UI is retained for reference and marked as deprecated
- Application successfully deployed and tested on Apache Tomcat 10

---

## 👨‍💻 Author

**Fitness Tracker – Java Web Application**  
Developed for academic and learning purposes.

---

## 📄 License

This project is created strictly for educational use.
