package com.example.bookclub.dto;

import com.example.bookclub.model.MembershipType;

import java.util.List;

public class MemberResponseDTO {

    private long id;
    private String name;
    private String email;
    private MembershipType membershipType;

    private List<BookResponseDTO> borrowedBooks; // Carrega a lista de livros emprestados do membro

    public MemberResponseDTO() {
    }

    public MemberResponseDTO(long id, String name, String email, MembershipType membershipType, List<BookResponseDTO> borrowedBooks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.membershipType = membershipType;
        this.borrowedBooks = borrowedBooks;
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

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public List<BookResponseDTO> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<BookResponseDTO> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
