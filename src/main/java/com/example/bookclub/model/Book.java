package com.example.bookclub.model;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String author;
    private String genre;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @ManyToOne
    @JoinColumn(name = "borrowed_by")
    private Member borrowedBy;

    public Book() {
    }

    public Book(long id, String title, String author, String genre, LocalDate borrowDate, LocalDate dueDate, BookStatus bookStatus, Member borrowedBy) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.bookStatus = bookStatus;
        this.borrowedBy = borrowedBy;
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

    public Member getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Member borrowedBy) {
        this.borrowedBy = borrowedBy;
    }
}
