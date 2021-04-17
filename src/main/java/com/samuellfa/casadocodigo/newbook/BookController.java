package com.samuellfa.casadocodigo.newbook;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @PersistenceContext
    private EntityManager manager;
    
    @PostMapping("/books")
    @Transactional
    public String create(@Valid @RequestBody NewBookRequest request) {
        var book = request.toModel(manager);
        manager.persist(book);
        return book.toString();
    }
}
