package com.example.BaiTuan2.Controllers;

import com.example.BaiTuan2.Model.Book;
import com.example.BaiTuan2.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books") // Định nghĩa đường dẫn gốc là /books
public class BookController {

    @Autowired
    private BookService bookService;

    // 1. Xem danh sách sách (GET /books)
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    // 2. Hiển thị form thêm sách (GET /books/add)
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    // 3. Xử lý thêm sách (POST /books/add)
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    // 4. Hiển thị form sửa sách (GET /books/edit/{id})
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            model.addAttribute("book", book);
            return "edit-book";
        }
        return "redirect:/books";
    }

    // 5. Xử lý cập nhật sách (POST /books/edit)
    @PostMapping("/edit")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookService.updateBook(book);
        return "redirect:/books";
    }

    // 6. Xử lý xóa sách (GET /books/delete/{id})
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
