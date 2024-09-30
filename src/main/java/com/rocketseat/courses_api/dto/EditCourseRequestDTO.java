package com.rocketseat.courses_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditCourseRequestDTO {
    private String name;
    private String category;
}
