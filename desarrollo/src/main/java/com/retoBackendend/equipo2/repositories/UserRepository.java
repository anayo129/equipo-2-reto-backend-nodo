package com.retoBackendend.equipo2.repositories;

import com.retoBackendend.equipo2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
    List<User> findByUsername(String username);
}
