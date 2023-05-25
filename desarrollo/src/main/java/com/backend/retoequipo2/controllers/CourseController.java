package com.backend.retoequipo2.controllers;

import com.backend.retoequipo2.dto.BodyNamesAndDescriptionsDto;
import com.backend.retoequipo2.dto.CourseNameAndDescriptionsDto;
import com.backend.retoequipo2.dto.CourseRequestDto;
import com.backend.retoequipo2.model.Body;
import com.backend.retoequipo2.model.Course;
import com.backend.retoequipo2.repositories.BodyRepository;
import com.backend.retoequipo2.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
//@RequestMapping("/api/course")
public class CourseController {


    private final CourseService courseService;
    private final BodyRepository bodyRepository;

    @Autowired
    public CourseController(CourseService courseService, BodyRepository bodyRepository) {
        this.courseService = courseService;
        this.bodyRepository = bodyRepository;
    }

    @PostMapping("/api/course")
    public ResponseEntity<Course> createCourse(@RequestBody CourseRequestDto courseRequestDto) {
        Course course = new Course();
        course.setNombre(courseRequestDto.getNombre());
        course.setPrecio(courseRequestDto.getPrecio());
        course.setImagen(courseRequestDto.getImagen());
        course.setDescripcion(courseRequestDto.getDescripcion());

        // Obtener el Body correspondiente al ID recibido en el DTO
        Long bodyId = courseRequestDto.getId_cuerpo();
        Body body = bodyRepository.findById(bodyId)
                .orElseThrow(() -> new NoSuchElementException("No existe un cuerpo con este id: " + bodyId));

        course.setId_cuerpo(body);

        Course createdCourse = courseService.createCourse(course);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
    }

    @GetMapping("/api/course")
    public List<Course> getAllCourses() {

        return courseService.getAllCourses();
    }

    @GetMapping("/api/course/{courseId}")
    public Course getCourseById(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/api/course/names-descriptions")
    public List<CourseNameAndDescriptionsDto> getCoursesNamesAndDescriptions() {
        return courseService.getCourseNamesAndDescriptions();
    }
}
