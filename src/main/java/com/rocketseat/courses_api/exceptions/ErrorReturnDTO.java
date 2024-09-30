package com.rocketseat.courses_api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorReturnDTO {
    private Integer status;
    private String message;
}
