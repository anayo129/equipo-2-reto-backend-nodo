package com.retoBackendend.equipo2.repositories;
import com.retoBackendend.equipo2.models.Body;
import com.retoBackendend.equipo2.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByCuerpoId(Long idCuerpo);
}
