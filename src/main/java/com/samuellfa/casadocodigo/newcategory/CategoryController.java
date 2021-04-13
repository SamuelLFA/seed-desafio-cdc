package com.samuellfa.casadocodigo.newcategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public String create(@RequestBody @Valid NewCategoryRequest request) {
        var category = request.toModel();
        manager.persist(category);
        return category.toString();
    }
}
