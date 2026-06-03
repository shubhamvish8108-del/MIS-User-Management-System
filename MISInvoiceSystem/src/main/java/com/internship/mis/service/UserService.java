package com.internship.mis.service;

import com.internship.mis.model.User;
import com.internship.mis.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * User Service
 * 
 * For beginners: This handles business logic for user operations.
 * Service layer sits between Controller and Repository.
 */
@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    // Constructor - Spring automatically injects the dependencies
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    /**
     * Register a new user
     */
    public User registerUser(String fullName, String email, String password, String role) {
        // Check if email already exists
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists!");
        }
        
        // Encode the password (for security)
        String encodedPassword = passwordEncoder.encode(password);
        
        // Create and save the new user
        User user = new User(fullName, email, encodedPassword, role);
        return userRepository.save(user);
    }
    
    /**
     * Find user by email
     */
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    /**
     * Authenticate user - verify email and password
     * Returns the user if credentials are valid, empty Optional otherwise
     */
    public Optional<User> authenticate(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // Check if user is active
            if (user.isActive() && passwordEncoder.matches(password, user.getPasswordHash())) {
                return Optional.of(user);
            }
        }
        
        return Optional.empty();
    }
    
    /**
     * Check if email is available
     */
    public boolean isEmailAvailable(String email) {
        return !userRepository.existsByEmail(email);
    }
}