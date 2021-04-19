package com.samuellfa.casadocodigo.newcountry;

public class NewCountryResponse {

    private String name;

    public NewCountryResponse(Country country) {
        name = country.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
