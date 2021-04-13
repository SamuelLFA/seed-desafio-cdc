package com.samuellfa.casadocodigo.shared;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue params) {
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        var query = manager.createQuery("SELECT 1 FROM " + klass.getName() + " where " + domainAttribute + "=:value");
        query.setParameter("value", value);
        var list = query.getResultList();
        Assert.state(list.size() <= 1, "Was found more than one " + klass + "with the attribute " + domainAttribute);

        return list.isEmpty();
    }
    
}
