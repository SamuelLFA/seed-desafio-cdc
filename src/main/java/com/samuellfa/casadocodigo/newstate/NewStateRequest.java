package com.samuellfa.casadocodigo.newstate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.samuellfa.casadocodigo.newcountry.Country;
import com.samuellfa.casadocodigo.newcountry.CountryRepository;
import com.samuellfa.casadocodigo.shared.ExistsId;
import com.samuellfa.casadocodigo.shared.UniqueValue;

public class NewStateRequest {

    @UniqueValue(domainClass = State.class, fieldName = "name", message = "{country.name.unique}")
    @NotBlank
    private String name;

    @NotNull
    @ExistsId(domainClass = Country.class, fieldName = "id")
    private Long idCountry;

    public NewStateRequest(@NotBlank String name, @NotNull Long idCountry) {
        this.name = name;
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    public State toModel(CountryRepository countryRepository) {
        var countryOptional = countryRepository.findById(idCountry);
        if (countryOptional.isEmpty()) {
            throw new IllegalArgumentException("This country does not exist");
        }
        return new State(name, countryOptional.get());
    }
}
