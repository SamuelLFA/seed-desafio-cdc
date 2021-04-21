package com.samuellfa.casadocodigo.newpayment;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class NewItemRequest {

    @NotNull
    private Long idBook;
    @NotNull
    @Min(value = 1)
    private Long quantity;

    public NewItemRequest(@NotNull Long idBook, @NotNull @Min(1) Long quantity) {
        this.idBook = idBook;
        this.quantity = quantity;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
