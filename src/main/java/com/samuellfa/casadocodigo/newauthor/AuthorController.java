package com.samuellfa.casadocodigo.newauthor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @PersistenceContext
    public EntityManager manager;
    
    @PostMapping(value = "/authors")
    @Transactional
    public String create(@RequestBody @Valid NewAuthorRequest request) {
        var author = request.toModel();
        manager.persist(author);
        return author.toString();
    }
}
