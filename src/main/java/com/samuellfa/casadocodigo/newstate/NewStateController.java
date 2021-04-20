package com.samuellfa.casadocodigo.newstate;

import javax.validation.Valid;

import com.samuellfa.casadocodigo.newcountry.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class NewStateController {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;
    
    @PostMapping("/states")
    public ResponseEntity<NewStateResponse> create(@RequestBody @Valid NewStateRequest request, UriComponentsBuilder uriBuilder) {
        var state = request.toModel(countryRepository);
        stateRepository.save(state);
        
        var newStateResponse = new NewStateResponse(state);
        var uri = uriBuilder.path("/countries/{id}").buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).body(newStateResponse);
    }
}
