package com.samuellfa.casadocodigo.newcategory;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/categories")
public class NewCategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<NewCategoryResponse> create(@RequestBody @Valid NewCategoryRequest request, UriComponentsBuilder uriBuilder) {
        var category = request.toModel();
        categoryRepository.save(category);

        var newCategoryResponse = new NewCategoryResponse(category);
        var uri = uriBuilder.path("/books/{id}").buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(uri).body(newCategoryResponse);
    }
}
