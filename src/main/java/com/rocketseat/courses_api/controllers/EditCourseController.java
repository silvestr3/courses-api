package com.rocketseat.courses_api.controllers;

import com.rocketseat.courses_api.dto.EditCourseRequestDTO;
import com.rocketseat.courses_api.entities.Course;
import com.rocketseat.courses_api.use_cases.EditCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;

@RestController
@RequestMapping("/cursos/{id}")
public class EditCourseController {
    @Autowired
    EditCourse editCourse;

    @PutMapping()
    public ResponseEntity<Object> handle(
            @PathVariable String id,
            @RequestBody EditCourseRequestDTO body
    ) throws InstanceNotFoundException {
        Course course = this.editCourse.execute(id, body.getName(), body.getCategory());

        return ResponseEntity.ok().body(course);
    }
}
