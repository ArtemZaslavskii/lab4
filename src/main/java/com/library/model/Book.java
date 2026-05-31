package com.library.model;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

public class Book {

    @SerializedName("name")
    private String name;

    @SerializedName("author")
    private String author;

    @SerializedName("publishingYear")
    private int publishingYear;

    @SerializedName("isbn")
    private String isbn;

    @SerializedName("publisher")
    private String publisher;

    public String getName() { return name; }
    public String getAuthor() { return author; }
    public int getPublishingYear() { return publishingYear; }
    public String getIsbn() { return isbn; }
    public String getPublisher() { return publisher; }

    // Нужно для distinct() в задании 2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}