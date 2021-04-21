package com.samuellfa.casadocodigo.shared;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FutureDateValueValidator implements ConstraintValidator<FutureDateValue, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value != null) {
            var today = LocalDate.now();
            return ((LocalDate) value).isAfter(today);
        }
        return true;
    }
}
