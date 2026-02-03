package com.example.BaiTuan2.Service;

import com.example.BaiTuan2.Model.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private int nextId = 1; // Biến để tự tăng ID

    // Constructor: Tạo dữ liệu giả lập
    public BookService() {
        books.add(new Book(nextId++, "Spring Boot Demo", "Nguyen Van A"));
        books.add(new Book(nextId++, "Hoc Java Co Ban", "Tran Van B"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addBook(Book book) {
        book.setId(nextId++); // Gán ID mới rồi tăng biến đếm lên
        books.add(book);
    }

    public void updateBook(Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == updatedBook.getId()) {
                books.set(i, updatedBook);
                break;
            }
        }
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
