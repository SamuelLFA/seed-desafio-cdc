package com.samuellfa.casadocodigo.newpayment;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.samuellfa.casadocodigo.newbook.Book;
import com.samuellfa.casadocodigo.newbook.BookRepository;
import com.samuellfa.casadocodigo.shared.ExistsId;

public class NewItemRequest {

    @NotNull
    @ExistsId(domainClass = Book.class, fieldName = "id", message = "{item.book.nonexist}")
    private Long idBook;
    @NotNull
    @Positive
    private int quantity;

    public NewItemRequest(@NotNull Long idBook, @NotNull @Min(1) int quantity) {
        this.idBook = idBook;
        this.quantity = quantity;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item toModel(BookRepository bookRepository) {
        var bookOptional = bookRepository.findById(idBook);
        if (bookOptional.isEmpty()) {
            throw new IllegalArgumentException("The book " + idBook + "does not exist");
        }

        return new Item(bookOptional.get(), quantity);
    }
}
