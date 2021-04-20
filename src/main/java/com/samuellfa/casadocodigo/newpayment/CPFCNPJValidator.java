package com.samuellfa.casadocodigo.newpayment;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

public class CPFCNPJValidator implements ConstraintValidator<CPFCNPJ, String> {

	private CPFValidator cpfValidator;
    private CNPJValidator cnpjValidator;

	@Override
	public void initialize(CPFCNPJ constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);

		cpfValidator = new CPFValidator();
    	cnpjValidator = new CNPJValidator();
		cpfValidator.initialize(null);
		cnpjValidator.initialize(null);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return (cpfValidator.isValid(value, context) || cnpjValidator.isValid(value, context));
	}
}
