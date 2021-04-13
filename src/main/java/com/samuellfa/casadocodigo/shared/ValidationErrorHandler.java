package com.samuellfa.casadocodigo.shared;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationErrorHandler {
    
    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorsOutputDto handleValidationError(MethodArgumentNotValidException exception) {
        var globalErrors = exception.getBindingResult().getGlobalErrors();
        var fieldErrors = exception.getBindingResult().getFieldErrors();

        return buildValidationError(globalErrors, fieldErrors);
    }

    private ValidationErrorsOutputDto buildValidationError(List<ObjectError> globalErrors,
            List<FieldError> fieldErrors) {
        var validationErrors = new ValidationErrorsOutputDto();
        globalErrors.forEach(error -> validationErrors.addError(getErrorMessage(error)));
        fieldErrors.forEach(error -> {
            var errorMessage = getErrorMessage(error);
            validationErrors.addFieldError(error.getField(), errorMessage);
        });

        return validationErrors;
    }

    private String getErrorMessage(ObjectError error) {
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }

    private String getErrorMessage(FieldError error) {
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }
}
