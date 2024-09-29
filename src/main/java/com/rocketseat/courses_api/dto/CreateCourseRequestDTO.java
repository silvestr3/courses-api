package com.rocketseat.courses_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCourseRequestDTO {
    @NotBlank(message = "Course name must be provided")
    private String name;

    @NotBlank(message = "Course category must be provided")
    private String category;
}
