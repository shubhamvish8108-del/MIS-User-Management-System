package com.internship.mis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home Controller
 * 
 * For beginners: This handles the homepage and root URL.
 */
@Controller
public class HomeController {
    
    // Home page
    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }
}