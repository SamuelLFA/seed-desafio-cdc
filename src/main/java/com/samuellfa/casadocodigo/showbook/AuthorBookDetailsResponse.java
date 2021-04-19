package com.samuellfa.casadocodigo.showbook;

import com.samuellfa.casadocodigo.newauthor.Author;

public class AuthorBookDetailsResponse {

    private String name;
    private String email;
    private String description;

    public AuthorBookDetailsResponse(Author author) {
        name = author.getName();
        email = author.getEmail();
        description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
