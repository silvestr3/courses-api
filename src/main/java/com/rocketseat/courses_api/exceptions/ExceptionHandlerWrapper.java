package com.rocketseat.courses_api.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.management.InstanceNotFoundException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerWrapper {
    private final MessageSource messageSource;

    public ExceptionHandlerWrapper(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorMessageDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        List<ValidationErrorMessageDTO> errors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String message = this.messageSource.getMessage(
                    error,
                    LocaleContextHolder.getLocale()
            );

            ValidationErrorMessageDTO dto = new ValidationErrorMessageDTO(message, error.getField());
            errors.add(dto);
        });

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(InstanceNotFoundException.class)
    public ResponseEntity<ErrorReturnDTO> handleInstanceNotFoundException(InstanceNotFoundException ex){
        ErrorReturnDTO response = new ErrorReturnDTO(
                HttpStatus.NOT_FOUND.value(),
                "Resource not found"
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorReturnDTO> handleException(Exception ex){
        ErrorReturnDTO response = new ErrorReturnDTO(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
