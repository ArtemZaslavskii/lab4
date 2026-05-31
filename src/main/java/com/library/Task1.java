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

public class Task1 {
    public static void main(String[] args) {

        Gson gson = new Gson();

        Reader reader = new InputStreamReader(
            Objects.requireNonNull(
                Task1.class.getClassLoader().getResourceAsStream("book.json")
            ),
            StandardCharsets.UTF_8
        );

        Type type = new TypeToken<List<Visitor>>() {}.getType();
        List<Visitor> visitors = gson.fromJson(reader, type);

        // Задание 1: список посетителей и их количество
        visitors.stream()
                .forEach(v -> System.out.println(v.getName() + " " + v.getSurname()));

        System.out.println("Количество посетителей: " + visitors.size());
    }
}