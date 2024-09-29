package com.rocketseat.courses_api.repository;

import com.rocketseat.courses_api.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoursesRepository extends JpaRepository<Course, UUID> {}
