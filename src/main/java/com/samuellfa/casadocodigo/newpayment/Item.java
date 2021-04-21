package com.samuellfa.casadocodigo.newpayment;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.samuellfa.casadocodigo.newbook.Book;

@Embeddable
public class Item {

    @ManyToOne
    private Book book;
    private int quantity;
    private BigDecimal partialPrice;

    public Item() {}
    
    public Item(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
        this.partialPrice = book.getPrice();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal total() {
		return partialPrice.multiply(new BigDecimal(quantity));
	}
}
