package com.retoBackendend.equipo2.services;


import com.retoBackendend.equipo2.repositories.CourseRepository;
import com.retoBackendend.equipo2.config.NotFoundException;
import com.retoBackendend.equipo2.dto.CourseNameAndDescriptionsDto;
import com.retoBackendend.equipo2.models.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCursosPorIdCuerpo(Long idCuerpo) {
        return courseRepository.findByCuerpoId(idCuerpo);
    }



    public Course createCourse(Course course) {

        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new NotFoundException(courseId, "curso"));
    }

    public List<CourseNameAndDescriptionsDto> getCourseNamesAndDescriptions() {
        List<Course> courses = courseRepository.findAll();
        List<CourseNameAndDescriptionsDto> result = new ArrayList<>();

        for (Course course : courses) {
            CourseNameAndDescriptionsDto dto = new CourseNameAndDescriptionsDto(course.getNombre(), course.getDescripcion());
            result.add(dto);
        }

        return result;
    }




}
