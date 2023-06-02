package com.retoBackendend.equipo2.repositories;


import com.retoBackendend.equipo2.models.Body;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BodyRepository extends JpaRepository<Body, Long> {

}
