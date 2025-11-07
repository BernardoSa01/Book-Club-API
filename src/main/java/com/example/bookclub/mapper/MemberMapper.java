package com.example.bookclub.mapper;

import com.example.bookclub.dto.MemberRequestDTO;
import com.example.bookclub.dto.MemberResponseDTO;
import com.example.bookclub.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class MemberMapper {

    @Autowired
    private BookMapper bookMapper;


    public Member toEntity(MemberRequestDTO dto) {
        if (dto == null) return null;

        Member member = new Member();
        member.setName(dto.getName());
        member.setEmail(dto.getEmail());
        member.setPassword(dto.getPassword());
        member.setMembershipType(dto.getMembershipType());

        return member;
    }

    public MemberResponseDTO toDto(Member entity) {
        if (entity == null) return null;

        MemberResponseDTO memberDto = new MemberResponseDTO();
        memberDto.setId(entity.getId());
        memberDto.setName(entity.getName());
        memberDto.setEmail(entity.getEmail());
        memberDto.setMembershipType(entity.getMembershipType());

        // Garante que borrowedBooks nunca seja null
        memberDto.setBorrowedBooks(
                entity.getBooks() != null
                        ? entity.getBooks().stream()
                        .map(bookMapper::toDto)
                        .collect(Collectors.toList())
                        : new ArrayList<>() // caso null, retorna []
        );

        return memberDto;
    }
}
