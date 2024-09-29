package com.rocketseat.courses_api.use_cases;

import com.rocketseat.courses_api.dto.CreateCourseRequestDTO;
import com.rocketseat.courses_api.entities.Course;
import com.rocketseat.courses_api.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourse {
    @Autowired
    CoursesRepository coursesRepository;

    public Course execute(CreateCourseRequestDTO params){
        Course course = Course
                .builder()
                .name(params.getName())
                .category(params.getCategory())
                .isActive(true)
                .build();

        return this.coursesRepository.save(course);
    }
}
