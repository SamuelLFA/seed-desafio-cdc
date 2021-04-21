package com.samuellfa.casadocodigo.newauthor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class NewAuthorController {

    @Autowired
    public AuthorRepository authorRepository;
    
    @PostMapping(value = "/authors")
    @Transactional
    public ResponseEntity<NewAuthorResponse> create(@RequestBody @Valid NewAuthorRequest request, UriComponentsBuilder uriBuilder) {
        var author = request.toModel();
        authorRepository.save(author);

        var newAuthorResponse = new NewAuthorResponse(author);
        var uri = uriBuilder.path("/authors/{id}").buildAndExpand(author.getId()).toUri();

        return ResponseEntity.created(uri).body(newAuthorResponse);
    }
}
