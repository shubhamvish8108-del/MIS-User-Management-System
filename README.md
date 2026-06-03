# MIS Invoice System

A simple Login and Registration System for a Management Information System (MIS) with Invoice Generation.

**Built with:** Spring Boot, Spring Security, Thymeleaf, MySQL

---

## Quick Start (Beginner Friendly)

### Prerequisites

1. **Java 17+** - Download from https://adoptium.net/
2. **MySQL** - Download from https://dev.mysql.com/downloads/mysql/
3. **IntelliJ IDEA** - Download from https://www.jetbrains.com/idea/

### Step 1: Setup MySQL Database

1. Open MySQL Workbench or command line
2. Run the SQL script to create database:

```sql
CREATE DATABASE IF NOT EXISTS mis_invoice_db;
```

3. The table will be created automatically by Spring Boot (JPA).

---

### Step 2: Update Database Password

1. Open: `src/main/resources/application.properties`
2. Change `YOUR_PASSWORD_HERE` to your MySQL password:

```properties
spring.datasource.password=YOUR_ACTUAL_PASSWORD
```

---

### Step 3: Open in IntelliJ

1. Open IntelliJ IDEA
2. File → Open → Select the `MISInvoiceSystem` folder
3. Wait for Maven to download dependencies (bottom right progress bar)
4. If prompted, mark `src/main/java` as Sources folder

---

### Step 4: Run the Application

1. Find `MISInvoiceApplication.java` in Project Explorer
2. Right-click → Run 'MISInvoiceApplication'
3. Wait for "Started MISInvoiceApplication" in console

---

### Step 5: Open in Browser

Go to: **http://localhost:8080**

You'll be redirected to the login page.

---

## Test Accounts (Pre-created)

| Role | Email | Password |
|------|-------|----------|
| Admin | admin@company.com | password123 |
| Sales Person | john@company.com | password123 |

---

## Project Structure

```
MISInvoiceSystem/
├── pom.xml                          # Maven dependencies
├── sql/
│   └── database_setup.sql           # Database script
├── src/main/
│   ├── java/com/internship/mis/
│   │   ├── MISInvoiceApplication.java    # Main class
│   │   ├── config/
│   │   │   ├── SecurityConfig.java       # Security settings
│   │   │   └── CustomUserDetailsService.java
│   │   ├── controller/
│   │   │   ├── AuthController.java       # Login/Register
│   │   │   ├── DashboardController.java  # Dashboard
│   │   │   └── HomeController.java
│   │   ├── model/
│   │   │   └── User.java                 # User entity
│   │   ├── repository/
│   │   │   └── UserRepository.java      # Database operations
│   │   └── service/
│   │       └── UserService.java         # Business logic
│   └── resources/
│       ├── application.properties        # Configuration
│       └── templates/
│           ├── login.html                # Login page
│           ├── register.html             # Registration page
│           ├── dashboard.html            # Dashboard page
│           └── admin/
│               └── users.html           # Admin panel
└── README.md
```

---

## Features

### Authentication
- ✅ User Registration (with role selection)
- ✅ User Login (email + password)
- ✅ Secure password hashing (BCrypt)
- ✅ Logout functionality
- ✅ Session management

### Role-Based Access Control
- **Admin**: Full access to all features
- **Sales Person**: Limited access (restricted features)

### User Management
- ✅ Role-based navigation
- ✅ Status tracking (active/inactive)
- ✅ Created timestamp

---

## How to Register a New User

1. Go to login page
2. Click "Register here"
3. Fill in the form:
    - Full Name
    - Email
    - Password (min 6 characters)
    - Confirm Password
    - Select Role (Admin or Sales Person)
4. Click "Register"
5. Login with your new account

---

## Troubleshooting

### "Connection refused" error
- Make sure MySQL is running
- Check your password in `application.properties`
- Make sure database `mis_invoice_db` exists

### Maven download stuck
- Go to File → Settings → Build Tools → Maven
- Check "Always update snapshots"
- Click Refresh in Maven tool window

### Port 8080 already in use
- Open `application.properties`
- Add: `server.port=8081`

---

## For Your Internship Report

This project demonstrates:
- Spring Boot web application
- Spring Security for authentication
- JPA/Hibernate for database operations
- Thymeleaf for frontend templates
- Role-Based Access Control (RBAC)
- Clean code with comments for beginners

---

## Next Steps (Suggested Extensions)

1. **Invoice Module** - Create invoice entity and CRUD
2. **Customer Module** - Manage customers
3. **Email Verification** - Send verification emails
4. **Dashboard Charts** - Show sales data
5. **Forgot Password** - Password reset via email
---

Good luck with your internship! 🚀