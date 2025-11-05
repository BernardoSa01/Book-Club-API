package com.example.bookclub.dto;

import com.example.bookclub.model.BookStatus;

import java.time.LocalDate;

public class BookResponseDTO {

    private long id;
    private String title;
    private String author;
    private String genre;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    private BookStatus bookStatus;

    public BookResponseDTO() {
    }

    public BookResponseDTO(long id, String title, String author, String genre, LocalDate borrowDate, LocalDate dueDate, BookStatus bookStatus) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.bookStatus = bookStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}
