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

public class Task5 {
    public static void main(String[] args) {

        Gson gson = new Gson();

        Reader reader = new InputStreamReader(
            Objects.requireNonNull(
                Task5.class.getClassLoader().getResourceAsStream("book.json")
            ),
            StandardCharsets.UTF_8
        );

        Type type = new TypeToken<List<Visitor>>() {}.getType();
        List<Visitor> visitors = gson.fromJson(reader, type);

        // Задание 5: максимальное число книг в избранном
        // mapToInt — переводим каждого посетителя в число (кол-во его книг)
        // max() — находим максимум, возвращает OptionalInt
        // orElse(0) — если список пустой, вернуть 0
        int maxBooks = visitors.stream()
                .mapToInt(v -> v.getFavoriteBooks().size())
                .max()
                .orElse(0);

        System.out.println("Максимум книг в избранном: " + maxBooks);
    }
}