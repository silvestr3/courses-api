package com.rocketseat.courses_api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationErrorMessageDTO {
    private String message;
    private String field;
}
