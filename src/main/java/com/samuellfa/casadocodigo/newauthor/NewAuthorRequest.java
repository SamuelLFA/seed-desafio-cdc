package com.samuellfa.casadocodigo.newauthor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.samuellfa.casadocodigo.shared.UniqueValue;

public class NewAuthorRequest {

    @NotBlank
    private String name;

    @UniqueValue(domainClass = Author.class, fieldName = "email", message = "{author.email.unique}")
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String description;

    public NewAuthorRequest(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank @Size(max = 400) String description
    ) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getEmail() {
        return this.email;
    }

    public Author toModel() {
        return new Author(this.name, this.email, this.description);
    }
}
