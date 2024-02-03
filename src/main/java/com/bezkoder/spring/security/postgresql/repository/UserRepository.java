package com.bezkoder.spring.security.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.security.postgresql.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);

  Boolean existsByUsername(String username);
  
  Boolean existsByUsernameAndEmail(String username, String email);
  
  Boolean  existsByUsernameAndPassword(String username, String password);  
  Boolean existsByEmail(String email);
}
