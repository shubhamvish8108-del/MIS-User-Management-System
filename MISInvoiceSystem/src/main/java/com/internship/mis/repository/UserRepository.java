package com.internship.mis.repository;

import com.internship.mis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * User Repository
 * 
 * For beginners: This interface automatically provides database operations.
 * Spring Data JPA creates the implementation automatically.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Method to find user by email - Spring Data JPA creates the query automatically
    Optional<User> findByEmail(String email);
    
    // Check if email already exists
    boolean existsByEmail(String email);
}