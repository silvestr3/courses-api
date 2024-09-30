package com.rocketseat.courses_api.use_cases;

import com.rocketseat.courses_api.entities.Course;
import com.rocketseat.courses_api.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.security.InvalidParameterException;
import java.util.Optional;
import java.util.UUID;

@Service
public class EditCourse {
    @Autowired
    private CoursesRepository coursesRepository;

    public Course execute(String id, String name, String category) throws InstanceNotFoundException{
        Optional<Course> result = this.coursesRepository.findById(UUID.fromString(id));

        if(result.isEmpty()){
            throw new InstanceNotFoundException();
        }

        if(name == null && category == null){
            throw new InvalidParameterException("Must provide either name or category to edit");
        }

        Course course = result.get();

        if(name != null && category == null){
            course.setName(name);
        } else if (name == null) {
            course.setCategory(category);
        }

        return this.coursesRepository.save(course);
    }
}
