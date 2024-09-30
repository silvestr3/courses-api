package com.rocketseat.courses_api.controllers;

import com.rocketseat.courses_api.use_cases.ToggleCourseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InstanceNotFoundException;

@RestController
@RequestMapping("/cursos/{id}/active")
public class ToggleCourseStatusController {
    @Autowired
    ToggleCourseStatus toggleCourseStatus;

    @PatchMapping()
    public ResponseEntity<Object> handle(@PathVariable String id) throws InstanceNotFoundException {
        this.toggleCourseStatus.execute(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
