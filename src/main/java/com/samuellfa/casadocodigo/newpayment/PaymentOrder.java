package com.samuellfa.casadocodigo.newpayment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.samuellfa.casadocodigo.newticket.Ticket;

@Entity
public class PaymentOrder {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @OneToOne
	private Payment payment;
    @ElementCollection
    private List<Item> items = new ArrayList<>();

    public PaymentOrder(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public BigDecimal total() {
        return items
            .stream()
            .map(Item::total)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
