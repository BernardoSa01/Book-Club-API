package com.example.bookclub.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Member {

    @Id // Garante que o Id será uma chave primária no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private MembershipType membershipType;

    @OneToMany(mappedBy = "borrowedBy")
    private List<Book> books;

    public Member() {
    }

    public Member(long id, String name, String email, String password, MembershipType membershipType, List<Book> books) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.membershipType = membershipType;
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> book) {
        this.books = book;
    }
}
