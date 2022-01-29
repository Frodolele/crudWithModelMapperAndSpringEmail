package com.frodolele.controller;

import com.frodolele.dto.BookDto;
import com.frodolele.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping("/getAll")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        val books = bookService.getAllBooks();

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/notifyStockedBooks")
    public void notifyStockedBooks() {
        bookService.notifyStockedBooks();
    }


}
