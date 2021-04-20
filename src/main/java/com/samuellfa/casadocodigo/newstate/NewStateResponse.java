package com.samuellfa.casadocodigo.newstate;

public class NewStateResponse {

    private String name;

    public NewStateResponse(State country) {
        name = country.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
