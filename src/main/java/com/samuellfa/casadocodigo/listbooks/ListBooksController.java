package com.samuellfa.casadocodigo.listbooks;

import com.samuellfa.casadocodigo.newbook.Book;
import com.samuellfa.casadocodigo.newbook.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListBooksController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public ResponseEntity<Iterable<Book>> list() {
        return ResponseEntity.ok().body(bookRepository.findAll());
    }
}
