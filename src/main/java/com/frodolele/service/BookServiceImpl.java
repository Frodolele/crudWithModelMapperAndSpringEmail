package com.frodolele.service;

import com.frodolele.dto.BookDto;
import com.frodolele.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final EmailSenderService emailSenderService;

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
            .stream()
            .map(it -> modelMapper.map(it, BookDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public void notifyStockedBooks() {
        val text = this.getAllBooks().toString();

        emailSenderService.sendEmail("prog.frodolele@yandex.ru", "Stocked books", text);
    }
}
