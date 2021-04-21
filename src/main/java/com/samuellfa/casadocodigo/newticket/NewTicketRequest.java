package com.samuellfa.casadocodigo.newticket;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.samuellfa.casadocodigo.shared.FutureDateValue;
import com.samuellfa.casadocodigo.shared.UniqueValue;

public class NewTicketRequest {

    @NotBlank
    @UniqueValue(domainClass = Ticket.class, fieldName = "code", message = "{ticket.code.unique}")
    private String code;
    @NotNull
    @Positive
    private BigDecimal percentage;
    @NotNull
    @FutureDateValue(message = "{ticket.validdate.future}")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    private LocalDate validDate;

    public NewTicketRequest(@NotBlank String code, @NotNull @Positive BigDecimal percentage, LocalDate validDate) {
        this.code = code;
        this.percentage = percentage;
        this.validDate = validDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public LocalDate getValidDate() {
        return validDate;
    }

    public void setValidDate(LocalDate validDate) {
        this.validDate = validDate;
    }

    public Ticket toModel() {
        return new Ticket(code, percentage, validDate);
    }
}
