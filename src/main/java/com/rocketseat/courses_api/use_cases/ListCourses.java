package com.rocketseat.courses_api.use_cases;

import com.rocketseat.courses_api.entities.Course;
import com.rocketseat.courses_api.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCourses {
    @Autowired
    CoursesRepository coursesRepository;

    public List<Course> execute(String name, String category){
        List<Course> courses;

        if(name != null) {
            courses = this.coursesRepository.findAllByNameContainingIgnoreCase(name);
        } else if (category != null){
            courses = this.coursesRepository.findAllByCategoryContainingIgnoreCase(category);
        } else {
            courses = this.coursesRepository.findAll();
        }

        return courses;
    }
}
