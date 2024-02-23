package com.ups.poo.service;

import com.ups.poo.domain.Book;
import com.ups.poo.dto.AuthorDTO;
import com.ups.poo.dto.BookDTO;
import com.ups.poo.repository.BookRepository;

import java.util.List;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> findAll() {
        Iterable<Book> books = bookRepository.findAll();
        for(Book bookI : books) {
            BookDTO book = new BookDTO();
            book.setTitle(bookI.getTitle());
            book.setEditorial(bookI.getEditorial());
            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setName(bookI.getAuthor().getName());
            authorDTO.setLastName(bookI.getAuthor().getLastName());
        }
    }
}
