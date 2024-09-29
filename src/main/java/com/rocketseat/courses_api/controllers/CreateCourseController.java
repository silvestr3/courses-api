package com.rocketseat.courses_api.controllers;

import com.rocketseat.courses_api.dto.CreateCourseRequestDTO;
import com.rocketseat.courses_api.entities.Course;
import com.rocketseat.courses_api.use_cases.CreateCourse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CreateCourseController {
    @Autowired
    CreateCourse createCourse;

    @PostMapping()
    public ResponseEntity<Course> handle(@Valid @RequestBody CreateCourseRequestDTO body){
        Course course = this.createCourse.execute(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }
}
