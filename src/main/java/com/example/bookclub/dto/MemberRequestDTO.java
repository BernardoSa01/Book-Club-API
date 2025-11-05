package com.example.bookclub.dto;

import com.example.bookclub.model.MembershipType;
import jakarta.validation.constraints.*;

public class MemberRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$",
        message = "A senha deve conter pelo menos uma letra maiúscula, uma minúscula e um número"
    )
    private String password;

    @NotNull(message = "Tipo de associação é obrigatório")
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
