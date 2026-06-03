-- =============================================
-- MIS Invoice System - Database Setup Script
-- For beginners: This creates the database and table
-- =============================================

-- Create the database (run this first if database doesn't exist)
CREATE DATABASE IF NOT EXISTS mis_invoice_db;
USE mis_invoice_db;

-- =============================================
-- Users Table
-- This stores all user information
-- =============================================

CREATE TABLE IF NOT EXISTS users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,  -- 'ADMIN' or 'SALESPERSON'
    status VARCHAR(20) DEFAULT 'active',  -- 'active' or 'inactive'
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =============================================
-- Sample Data
-- Run this to insert test users
-- Password for all: password123 (BCrypt encoded)
-- =============================================

-- Admin user (BCrypt hash of 'password123')
INSERT INTO users (full_name, email, password_hash, role, status) VALUES
('System Admin', 'admin@company.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'ADMIN', 'active');

-- Sales Person user (BCrypt hash of 'password123')
INSERT INTO users (full_name, email, password_hash, role, status) VALUES
('John Sales', 'john@company.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'SALESPERSON', 'active');

-- Another Sales Person
INSERT INTO users (full_name, email, password_hash, role, status) VALUES
('Jane Smith', 'jane@company.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'SALESPERSON', 'active');

-- =============================================
-- Useful Queries
-- =============================================

-- View all users
-- SELECT * FROM users;

-- View all admins
-- SELECT * FROM users WHERE role = 'ADMIN';

-- View active users only
-- SELECT * FROM users WHERE status = 'active';

-- Change user password (for admin to reset)
-- UPDATE users SET password_hash = 'NEW_HASH_HERE' WHERE email = 'user@email.com';

-- Deactivate a user
-- UPDATE users SET status = 'inactive' WHERE email = 'user@email.com';

-- =============================================
-- How to Generate BCrypt Password Hash
-- Run this SQL in your MySQL workbench if needed:
-- SELECT PASSWORD('yourpassword');
-- Or use an online BCrypt generator
-- =============================================