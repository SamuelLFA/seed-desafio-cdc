package com.samuellfa.casadocodigo.newcategory;

public class NewCategoryResponse {

    private String name;

    public NewCategoryResponse(Category category) {
        name = category.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
