package com.rocketseat.courses_api.controllers;

import com.rocketseat.courses_api.use_cases.DeleteCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InstanceNotFoundException;

@RestController
@RequestMapping("/cursos/{id}")
public class DeleteCourseController {
    @Autowired
    DeleteCourse deleteCourse;

    @DeleteMapping()
    public ResponseEntity<Object> handle(@PathVariable String id) throws InstanceNotFoundException {
        this.deleteCourse.execute(id);

        return ResponseEntity.noContent().build();
    }
}
