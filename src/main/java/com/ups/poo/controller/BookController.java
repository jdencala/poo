package com.ups.poo.controller;

import com.ups.poo.dto.BookDTO;
import com.ups.poo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/all-books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAllBooks() {
        List<BookDTO> bookList = new ArrayList<>();
        bookList = bookService.findAll();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
}
