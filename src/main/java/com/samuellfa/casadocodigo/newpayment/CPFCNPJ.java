package com.samuellfa.casadocodigo.newpayment;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { CPFCNPJValidator.class })
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPFCNPJ {

    String message() default "{com.samuellfa.beanvalidation.cpfcnpj}";

    Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
