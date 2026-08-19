package com.smartcare.hms.repository;

import com.smartcare.hms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByNicNumber(String nicNumber);
    Optional<User> findByEmail(String email);
    List<User> findByRole(String role);
}