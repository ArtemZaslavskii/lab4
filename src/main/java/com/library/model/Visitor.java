package com.library.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Visitor {

    @SerializedName("name")
    private String name;

    @SerializedName("surname")
    private String surname;

    @SerializedName("phone")
    private String phone;

    @SerializedName("subscribed")
    private boolean subscribed;

    @SerializedName("favoriteBooks")
    private List<Book> favoriteBooks;

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getPhone() { return phone; }
    public boolean isSubscribed() { return subscribed; }
    public List<Book> getFavoriteBooks() { return favoriteBooks; }
}