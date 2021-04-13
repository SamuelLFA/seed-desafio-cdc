package com.samuellfa.casadocodigo.newcategory;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    public Optional<Category> findByName(String name);
}
