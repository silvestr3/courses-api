package com.rocketseat.courses_api.controllers;

import com.rocketseat.courses_api.entities.Course;
import com.rocketseat.courses_api.use_cases.ListCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class ListCoursesController {
    @Autowired
    ListCourses listCourses;

    @GetMapping()
    public ResponseEntity<List<Course>> handle(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category
    ){
        List<Course> courses = this.listCourses.execute(name, category);

        return ResponseEntity.ok().body(courses);
    }
}
