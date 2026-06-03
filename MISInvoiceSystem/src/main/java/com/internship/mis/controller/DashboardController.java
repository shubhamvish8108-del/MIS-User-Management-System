package com.internship.mis.controller;

import com.internship.mis.model.User;
import com.internship.mis.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

/**
 * Dashboard Controller
 * 
 * For beginners: Handles the dashboard page after login.
 * Shows different content based on user role.
 */
@Controller
public class DashboardController {
    
    private final UserService userService;
    
    public DashboardController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        
        String email = authentication.getName();
        Optional<User> userOpt = userService.findByEmail(email);
        
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            model.addAttribute("user", user);
            model.addAttribute("isAdmin", user.isAdmin());
        }
        
        return "dashboard";
    }
    
    // Admin only page - test for role-based access
    @GetMapping("/admin/manage-users")
    public String manageUsers(Model model, Authentication authentication) {
        // This page will only be accessible by ADMIN role
        // (configured in SecurityConfig)
        model.addAttribute("message", "Welcome to Admin Panel - User Management");
        return "admin/users";
    }
}