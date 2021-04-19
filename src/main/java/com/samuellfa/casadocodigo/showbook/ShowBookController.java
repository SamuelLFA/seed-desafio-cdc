package com.samuellfa.casadocodigo.showbook;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.samuellfa.casadocodigo.newbook.Book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowBookController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDetailsResponse> show(@PathVariable Long id) {
        var book = manager.find(Book.class, id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        var bookDetailsResponse = new BookDetailsResponse(book);
        return ResponseEntity.ok().body(bookDetailsResponse);
    }
}
