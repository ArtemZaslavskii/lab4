package com.library;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.library.model.Visitor;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class Task4 {
    public static void main(String[] args) {

        Gson gson = new Gson();

        Reader reader = new InputStreamReader(
            Objects.requireNonNull(
                Task4.class.getClassLoader().getResourceAsStream("book.json")
            ),
            StandardCharsets.UTF_8
        );

        Type type = new TypeToken<List<Visitor>>() {}.getType();
        List<Visitor> visitors = gson.fromJson(reader, type);

        // Задание 4: есть ли книга Jane Austen у кого-то в избранном
        // anyMatch — возвращает true если хотя бы один элемент подходит
        boolean hasJaneAusten = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .anyMatch(b -> "Jane Austen".equals(b.getAuthor()));

        System.out.println("Есть книга Jane Austen в избранном: " + hasJaneAusten);
    }
}