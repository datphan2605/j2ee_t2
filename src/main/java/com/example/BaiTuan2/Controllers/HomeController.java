package com.example.BaiTuan2.Controllers;

import com.example.BaiTuan2.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    // 1. Trang Chủ (Chỉ là trang chào mừng)
    @GetMapping("/")
    public String home() {
        return "index"; // Trả về file index.html đơn giản
    }


}