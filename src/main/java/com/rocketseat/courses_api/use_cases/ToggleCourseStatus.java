package com.rocketseat.courses_api.use_cases;

import com.rocketseat.courses_api.entities.Course;
import com.rocketseat.courses_api.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ToggleCourseStatus {
    @Autowired
    CoursesRepository coursesRepository;

    public void execute(String id) throws InstanceNotFoundException {
        Optional<Course> result = this.coursesRepository.findById(UUID.fromString(id));

        if(result.isEmpty()){
            throw new InstanceNotFoundException();
        }

        Course course = result.get();

        course.setIsActive(!course.getIsActive());
        this.coursesRepository.save(course);
    }
}
