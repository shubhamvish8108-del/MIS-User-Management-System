package com.internship.mis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security Configuration
 * 
 * For beginners: This configures Spring Security rules.
 * It tells the app which pages need login, which roles can access what, etc.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    // BCrypt is a password hashing algorithm - safe and secure
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF for simplicity (in production, keep it enabled)
            .csrf(csrf -> csrf.disable())
            
            // Configure authorization rules
            .authorizeHttpRequests(auth -> auth
                // Public pages - anyone can access
                .requestMatchers("/", "/login", "/register", "/css/**", "/js/**").permitAll()
                
                // Admin only pages
                .requestMatchers("/admin/**").hasRole("ADMIN")
                
                // All other pages require authentication
                .anyRequest().authenticated()
            )
            
            // Configure login
            .formLogin(form -> form
                .loginPage("/login")                    // Custom login page
                .loginProcessingUrl("/login")           // Form action URL
                .defaultSuccessUrl("/dashboard", true) // Redirect after successful login
                .failureUrl("/login?error=true")         // Redirect on failed login
                .permitAll()
            )
            
            // Configure logout
            .logout(logout -> logout
                .logoutUrl("/logout")                   // Logout action URL
                .logoutSuccessUrl("/login?logout=true") // Redirect after logout
                .permitAll()
            );
        
        return http.build();
    }
}