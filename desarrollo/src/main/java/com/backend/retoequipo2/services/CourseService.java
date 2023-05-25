package com.backend.retoequipo2.services;

import com.backend.retoequipo2.dto.BodyNamesAndDescriptionsDto;
import com.backend.retoequipo2.dto.CourseNameAndDescriptionsDto;
import com.backend.retoequipo2.model.Body;
import com.backend.retoequipo2.model.Course;
import com.backend.retoequipo2.repositories.BodyRepository;
import com.backend.retoequipo2.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final BodyRepository bodyRepository;

    public CourseService(CourseRepository courseRepository, BodyRepository bodyRepository) {
        this.courseRepository = courseRepository;
        this.bodyRepository = bodyRepository;
    }

    public Course createCourse(Course course) {

        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("no hay un curso con este id: " + courseId));
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
