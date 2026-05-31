package com.library.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
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
}