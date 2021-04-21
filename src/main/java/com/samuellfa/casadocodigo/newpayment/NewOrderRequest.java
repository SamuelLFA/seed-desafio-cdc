package com.samuellfa.casadocodigo.newpayment;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewOrderRequest {
    
    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal total;
    @NotNull
    @Size(min = 1)
    private List<NewItemRequest> items;

    public NewOrderRequest(@NotNull @DecimalMin("0.00") BigDecimal total,
            @NotNull @Size(min = 1) List<NewItemRequest> items) {
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
}
