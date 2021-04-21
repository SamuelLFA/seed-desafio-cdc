package com.samuellfa.casadocodigo.newpayment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.samuellfa.casadocodigo.newbook.BookRepository;

public class NewOrderRequest {
    
    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal total;
    @NotNull
    @Size(min = 1)
    @Valid
    private List<NewItemRequest> items = new ArrayList<>();

    public NewOrderRequest(@NotNull @Positive BigDecimal total,
            @NotNull @Valid @Size(min = 1) List<NewItemRequest> items) {
        this.total = total;
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<NewItemRequest> getItems() {
        return items;
    }

    public void setItems(List<NewItemRequest> items) {
        this.items = items;
    }

    public PaymentOrder toModel(BookRepository bookRepository) {
        var itemsModel = items
            .stream()
            .map(item -> item.toModel(bookRepository))
            .collect(Collectors.toList());

        return new PaymentOrder(itemsModel);
    }
}
