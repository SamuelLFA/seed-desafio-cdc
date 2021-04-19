package com.samuellfa.casadocodigo.newbook;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.samuellfa.casadocodigo.newcategory.Category;

public class NewBookResponse {

    private AuthorNewBookResponse author;
    private String bookAbstract;
    private Category category;
    private String isbn;
    private int numberOfPages;
    private BigDecimal price;
    private LocalDate publishTime;
    private String summary;
    private String title;

    public NewBookResponse(Book book) {
        author = new AuthorNewBookResponse(book.getAuthor());
        bookAbstract = book.getBookAbstract();
        category = book.getCategory();
        isbn = book.getIsbn();
        numberOfPages = book.getNumberOfPages();
        price = book.getPrice();
        publishTime = book.getPublishTime();
        summary = book.getSummary();
        title = book.getTitle();
    }

    public AuthorNewBookResponse getAuthor() {
        return author;
    }

    public void setAuthor(AuthorNewBookResponse author) {
        this.author = author;
    }

    public String getBookAbstract() {
        return bookAbstract;
    }

    public void setBookAbstract(String bookAbstract) {
        this.bookAbstract = bookAbstract;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public LocalDate getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDate publishTime) {
        this.publishTime = publishTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
