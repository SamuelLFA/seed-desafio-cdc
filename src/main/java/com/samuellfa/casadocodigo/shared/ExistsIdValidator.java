package com.samuellfa.casadocodigo.shared;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {

    private String domainAttribute;
	private Class<?> klass;
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(ExistsId params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value == null) {
			return true;
		}
		
		Query query = manager.createQuery("SELECT 1 FROM " + klass.getName() + " where " + domainAttribute + "=:value");
		query.setParameter("value", value);	
	
		
		List<?> list = query.getResultList();
		Assert.isTrue(list.size() <= 1, "CAUTION: exists more than one " + klass + " with the attribute " + domainAttribute + " and value = " + value);
		
		return !list.isEmpty();
    }
    
}
