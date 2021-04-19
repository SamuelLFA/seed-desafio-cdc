package com.samuellfa.casadocodigo.newcountry;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
    
}
