package com.example.bookclub.dto;

import com.example.bookclub.model.MembershipType;

public class MemberRequestDTO {

    private String name;
    private String email;
    private String password;

    private MembershipType membershipType;

    public MemberRequestDTO() {
    }

    public MemberRequestDTO(String name, String email, String password, MembershipType membershipType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.membershipType = membershipType;
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
}
