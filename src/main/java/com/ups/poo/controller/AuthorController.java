package com.ups.poo.controller;

import com.ups.poo.dto.AuthorDTO;
import com.ups.poo.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/all-authors", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAllAuthors() {
        List<AuthorDTO> authorList = new ArrayList<>();
        authorList = authorService.findAll();
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }
}
