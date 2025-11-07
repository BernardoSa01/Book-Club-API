package com.example.bookclub.controller;

import com.example.bookclub.dto.BookRequestDTO;
import com.example.bookclub.dto.BookResponseDTO;
import com.example.bookclub.dto.MemberRequestDTO;
import com.example.bookclub.mapper.BookMapper;
import com.example.bookclub.model.Book;
import com.example.bookclub.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @PostMapping("/save")
    public ResponseEntity<BookResponseDTO> create(@Valid @RequestBody BookRequestDTO dto) {
        Book book = bookMapper.toEntity(dto);

        Book createdBook = bookService.save(book);

        BookResponseDTO response = bookMapper.toDto(createdBook);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> findById(@PathVariable Long id) {
        Book book = bookService.findById(id);

        BookResponseDTO response = bookMapper.toDto(book);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> findAll() {
        List<Book> books = bookService.findAll();

        // Lista vazia para abrigar os dtos
        List<BookResponseDTO> booksDto = new ArrayList<>();

        for (Book book : books) {
            BookResponseDTO bookDto = bookMapper.toDto(book);
            booksDto.add(bookDto);
        }

        return ResponseEntity.status(HttpStatus.OK).body(booksDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BookRequestDTO dto) {
        Book book = bookMapper.toEntity(dto);

        Book updatedBook = bookService.update(id, book);

        BookResponseDTO response = bookMapper.toDto(updatedBook);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
