package com.samuellfa.casadocodigo.newbook;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.samuellfa.casadocodigo.newauthor.AuthorRepository;
import com.samuellfa.casadocodigo.newcategory.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class NewBookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;
    
    @PostMapping("/books")
    @Transactional
    public ResponseEntity<NewBookResponse> create(@Valid @RequestBody NewBookRequest request, UriComponentsBuilder uriBuilder) {
        var book = request.toModel(categoryRepository, authorRepository);
        bookRepository.save(book);

        var newBookResponse = new NewBookResponse(book);
        var uri = uriBuilder.path("/books/{id}").buildAndExpand(book.getId()).toUri();

        return ResponseEntity.created(uri).body(newBookResponse);
    }
}
