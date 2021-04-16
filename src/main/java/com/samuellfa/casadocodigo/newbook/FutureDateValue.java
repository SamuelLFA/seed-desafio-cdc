package com.samuellfa.casadocodigo.newbook;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {FutureDateValueValidator.class})
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FutureDateValue {

    String message() default "{com.samuellfa.beanvalidation.futuredate}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};
}
