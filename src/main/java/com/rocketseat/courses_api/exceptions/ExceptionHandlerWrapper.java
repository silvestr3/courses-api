package com.rocketseat.courses_api.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
}
