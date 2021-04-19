package com.samuellfa.casadocodigo.newbook;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.samuellfa.casadocodigo.newauthor.Author;
import com.samuellfa.casadocodigo.newauthor.AuthorRepository;
import com.samuellfa.casadocodigo.newcategory.Category;
import com.samuellfa.casadocodigo.newcategory.CategoryRepository;
import com.samuellfa.casadocodigo.shared.ExistsId;
import com.samuellfa.casadocodigo.shared.UniqueValue;

public class NewBookRequest {

    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "title", message = "{book.title.unique}")
    private String title;

    @NotBlank @Size(max = 500)
    private String bookAbstract;
    @NotBlank
    private String summary;
    @NotNull @DecimalMin(value = "20")
    private BigDecimal price;
    @NotNull @Min(value = 100)
    private int numberOfPages;
    @NotBlank
    private String isbn;
    @NotNull @FutureDateValue(message = "{book.publishtime.future}")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    private LocalDate publishTime;
    @NotNull @Min(value = 0)
    @ExistsId(domainClass = Category.class, fieldName = "id", message = "{book.category.nonexist}")
    private Long idCategory;
    @NotNull @Min(value = 0)
    @ExistsId(domainClass = Author.class, fieldName = "id", message = "{book.author.nonexist}")
    private Long idAuthor;

    public NewBookRequest(@NotBlank String title, @NotBlank @Size(max = 500) String bookAbstract, String summary,
            @NotNull @DecimalMin("20.00") BigDecimal price, @NotNull @Min(20) int numberOfPages, @NotBlank String isbn,
            @NotNull LocalDate publishTime, @NotNull @Min(value = 0) Long idCategory, @NotNull @Min(value = 0) Long idAuthor) {
        this.title = title;
        this.bookAbstract = bookAbstract;
        this.summary = summary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.publishTime = publishTime;
        this.idCategory = idCategory;
        this.idAuthor = idAuthor;
    }

    public Book toModel(CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        var categoryOptional = categoryRepository.findById(idCategory);
        if (categoryOptional.isEmpty()) {
            throw new IllegalArgumentException("This category does not exist");
        }
        var authorOptional = authorRepository.findById(idAuthor);
        if (authorOptional.isEmpty()) {
            throw new IllegalArgumentException("This author does not exist");
        }

        return new Book(title, bookAbstract, summary, price, numberOfPages, isbn, publishTime, categoryOptional.get(), authorOptional.get());
    }
}
