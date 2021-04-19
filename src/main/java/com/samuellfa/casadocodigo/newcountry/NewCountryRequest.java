package com.samuellfa.casadocodigo.newcountry;

import javax.validation.constraints.NotBlank;

import com.samuellfa.casadocodigo.shared.UniqueValue;

public class NewCountryRequest {

    @UniqueValue(domainClass = Country.class, fieldName = "name", message = "{country.name.unique}")
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country toModel() {
        return new Country(name);
    }
}
