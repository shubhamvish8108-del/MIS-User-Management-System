package com.internship.mis.controller;

import com.internship.mis.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Auth Controller
 * 
 * For beginners: Handles login and registration pages.
 */
@Controller
public class AuthController {
    
    private final UserService userService;
    
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    
    // Show login page
    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false) String error,
                           @RequestParam(required = false) String logout,
                           Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid email or password!");
        }
        if (logout != null) {
            model.addAttribute("logout", "You have been logged out successfully.");
        }
        return "login";
    }
    
    // Show registration page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
    
    // Handle registration form submission
    @PostMapping("/register")
    public String registerSubmit(@RequestParam String fullName,
                                @RequestParam String email,
                                @RequestParam String password,
                                @RequestParam String confirmPassword,
                                @RequestParam String role,
                                Model model) {
        
        // Validate passwords match
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match!");
            return "register";
        }
        
        // Validate password length
        if (password.length() < 6) {
            model.addAttribute("error", "Password must be at least 6 characters!");
            return "register";
        }
        
        try {
            // Register the user
            userService.registerUser(fullName, email, password, role);
            model.addAttribute("success", "Registration successful! Please login.");
            return "login";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}