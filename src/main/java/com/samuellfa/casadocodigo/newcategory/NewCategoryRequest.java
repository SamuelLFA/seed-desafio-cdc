package com.samuellfa.casadocodigo.newcategory;

import javax.validation.constraints.NotBlank;

import com.samuellfa.casadocodigo.shared.UniqueValue;

public class NewCategoryRequest {

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name", message = "{category.name.unique}")
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category toModel() {
        return new Category(this.name);
    }
}
