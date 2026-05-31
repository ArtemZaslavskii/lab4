package com.library;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.library.model.Book;
import com.library.model.Visitor;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {

        Gson gson = new Gson();

        Reader reader = new InputStreamReader(
            Objects.requireNonNull(
                Task2.class.getClassLoader().getResourceAsStream("book.json")
            ),
            StandardCharsets.UTF_8
        );

        Type type = new TypeToken<List<Visitor>>() {}.getType();
        List<Visitor> visitors = gson.fromJson(reader, type);

        // Задание 2: уникальные книги без повторений
        // flatMap — разворачивает List<Book> каждого посетителя в один общий поток
        // distinct — убирает дубликаты (сравнивает по isbn через equals)
        // collect — собирает обратно в список
        List<Book> uniqueBooks = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .distinct()
                .collect(Collectors.toList());

        uniqueBooks.forEach(b ->
                System.out.println(b.getName() + " - " + b.getAuthor())
        );

        System.out.println("Количество уникальных книг: " + uniqueBooks.size());
    }
}