package com.samuellfa.casadocodigo.newcountry;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class NewCountryController {

    @Autowired
    private CountryRepository countryRepository;
    
    @PostMapping("/countries")
    public ResponseEntity<NewCountryResponse> create(@RequestBody @Valid NewCountryRequest request, UriComponentsBuilder uriBuilder) {
        var country = request.toModel();
        countryRepository.save(country);
        
        var newCountryResponse = new NewCountryResponse(country);
        var uri = uriBuilder.path("/countries/{id}").buildAndExpand(country.getId()).toUri();
        return ResponseEntity.created(uri).body(newCountryResponse);
    }
}
