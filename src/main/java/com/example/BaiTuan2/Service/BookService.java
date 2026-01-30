package com.example.baituan2.service;

import com.example.baituan2.model.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(1, "Java Spring Boot", "Nguyen Thi A"));
        books.add(new Book(2, "Lap trinh Java", "Tran Thai B"));
        books.add(new Book(3, "Spring MVC", "Le Van C"));
    }

    public List<Book> getAllBooks() {
        return books;
    }
}
