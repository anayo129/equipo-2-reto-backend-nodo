package com.retoBackendend.equipo2.repositories;


import com.retoBackendend.equipo2.models.Body;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyRepository extends JpaRepository<Body, Long> {
}
