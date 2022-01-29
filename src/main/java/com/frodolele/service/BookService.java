package com.frodolele.service;

import com.frodolele.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks();

    void notifyStockedBooks();
}
