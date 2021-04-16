package com.samuellfa.casadocodigo.newbook;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.samuellfa.casadocodigo.newauthor.AuthorRepository;
import com.samuellfa.casadocodigo.newcategory.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @PersistenceContext
    private EntityManager manager;
    
    @PostMapping("/books")
    @Transactional
    public String create(@Valid @RequestBody NewBookRequest request) {
        var book = request.toModel(categoryRepository, authorRepository);
        manager.persist(book);
        return book.toString();
    }
}
