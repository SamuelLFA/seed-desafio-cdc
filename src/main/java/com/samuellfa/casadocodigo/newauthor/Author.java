package com.samuellfa.casadocodigo.newauthor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String name;
    private @NotBlank @Email String email;
    private @NotBlank @Size(max = 400) String description;
    private LocalDateTime instanteCreation = LocalDateTime.now();

    public Author() {
    }

    public Author(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank @Size(max = 400) String description)
    {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getInstanteCreation() {
        return instanteCreation;
    }

    public void setInstanteCreation(LocalDateTime instanteCreation) {
        this.instanteCreation = instanteCreation;
    }
}
