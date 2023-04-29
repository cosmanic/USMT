package com.ecotech.usmt.repositories;

import com.ecotech.usmt.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositry extends JpaRepository <UserDetails, Long>{
    Optional<UserDetails> findByEmailAndPassword(String email, String password);
}
