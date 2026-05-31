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
import java.util.stream.Collectors;

public class Task6 {
    public static void main(String[] args) {

        Gson gson = new Gson();

        Reader reader = new InputStreamReader(
            Objects.requireNonNull(
                Task6.class.getClassLoader().getResourceAsStream("book.json")
            ),
            StandardCharsets.UTF_8
        );

        Type type = new TypeToken<List<Visitor>>() {}.getType();
        List<Visitor> visitors = gson.fromJson(reader, type);

        // Считаем среднее количество книг по ВСЕМ посетителям
        double average = visitors.stream()
                .mapToInt(v -> v.getFavoriteBooks().size())
                .average()
                .orElse(0.0);

        System.out.println("Среднее количество книг: " + average);

        // Задание 6: SMS только для подписчиков (subscribed = true)
        // filter — оставляем только подписчиков
        // map — для каждого создаём строку с телефоном и сообщением
        visitors.stream()
                .filter(v -> v.isSubscribed())
                .map(v -> {
                    int count = v.getFavoriteBooks().size();
                    String message;
                    if (count > average) {
                        message = "you are a bookworm";
                    } else if (count < average) {
                        message = "read more";
                    } else {
                        message = "fine";
                    }
                    return v.getPhone() + " -> " + message;
                })
                .forEach(sms -> System.out.println(sms));
    }
}