package com.internship.mis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Application class for MIS Invoice System
 * 
 * This is a simple Spring Boot application with login and registration functionality.
 * For beginners: This class starts the entire application.
 */
@SpringBootApplication
public class MISInvoiceApplication {

    public static void main(String[] args) {
        // This line starts the Spring Boot application
        SpringApplication.run(MISInvoiceApplication.class, args);
        System.out.println("========================================");
        System.out.println("MIS Invoice System is running!");
        System.out.println("Open http://localhost:8080 in your browser");
        System.out.println("========================================");
    }
}