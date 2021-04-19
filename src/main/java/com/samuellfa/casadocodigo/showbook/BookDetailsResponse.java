package com.samuellfa.casadocodigo.showbook;

import java.math.BigDecimal;

import com.samuellfa.casadocodigo.newbook.Book;

public class BookDetailsResponse {
    
    private AuthorBookDetailsResponse author;
    private String title;
    private String isbn;
    private int numberOfPages;
    private BigDecimal price;
    private String bookAbstract;
    private String summary;

    public BookDetailsResponse(Book book) {
        title = book.getTitle();
        author = new AuthorBookDetailsResponse(book.getAuthor());
        isbn = book.getIsbn();
        numberOfPages = book.getNumberOfPages();
        price = book.getPrice();
        bookAbstract = book.getBookAbstract();
        summary = book.getSummary();
    }

    public AuthorBookDetailsResponse getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBookDetailsResponse author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBookAbstract() {
        return bookAbstract;
    }

    public void setBookAbstract(String bookAbstract) {
        this.bookAbstract = bookAbstract;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
