package com.example.bookclub.mapper;

import com.example.bookclub.dto.BookRequestDTO;
import com.example.bookclub.dto.BookResponseDTO;
import com.example.bookclub.model.Book;
import com.example.bookclub.model.BookStatus;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(BookRequestDTO dto) {
        if (dto == null) return null;

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setGenre(dto.getGenre());
        book.setBookStatus(BookStatus.AVAILABLE);

        return book;
    }

    public BookResponseDTO toDto(Book entity) {
        if (entity == null) return null;

        BookResponseDTO bookDto = new BookResponseDTO();
        bookDto.setId(entity.getId());
        bookDto.setTitle(entity.getTitle());
        bookDto.setAuthor(entity.getAuthor());
        bookDto.setGenre(entity.getGenre());
        bookDto.setBookStatus(entity.getBookStatus());
        bookDto.setBorrowDate(entity.getBorrowDate());
        bookDto.setDueDate(entity.getDueDate());

        return bookDto;
    }
}
