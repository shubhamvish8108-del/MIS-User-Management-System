# MIS User Management System

A secure Role-Based Access Control (RBAC) system developed for an MIS and Invoice Generation application.

The system provides user registration, authentication, authorization, session management, and role-based access control for Admin and Sales Person users.

## Features

### Authentication
- User Registration
- Secure Login
- Logout Functionality
- Forgot Password
- Reset Password
- Email Verification

### Authorization
- Admin Role
    - Manage Users
    - Access All Features
    - Manage System Data

- Sales Person Role
    - Restricted Access
    - Access Assigned Functionalities
    - Invoice Operations

### Security
- Password Encryption
- Role-Based Access Control (RBAC)
- Session Management
- Secure Authentication
- Account Status Management

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA

### Database
- MySQL

### Build Tool
- Maven

## Database Design

### Users Table

| Column | Description |
|----------|-------------|
| user_id | Unique User ID |
| full_name | User Full Name |
| email | User Email |
| password_hash | Encrypted Password |
| role | ADMIN / SALES_PERSON |
| status | ACTIVE / INACTIVE |
| created_at | Account Creation Timestamp |

## Project Structure

src/main/java

├── controller

├── service

├── repository

├── entity

├── dto

├── security

├── config

└── exception

## Future Enhancements

- JWT Authentication
- Email Notifications
- Audit Logs
- User Activity Tracking
- Invoice Management Module

## Author

Developed as part of a Java Developer Internship Assignment.