package com.example.bookclub.controller;

import com.example.bookclub.dto.MemberRequestDTO;
import com.example.bookclub.dto.MemberResponseDTO;
import com.example.bookclub.mapper.MemberMapper;
import com.example.bookclub.model.Member;
import com.example.bookclub.service.MemberService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberMapper memberMapper;


    @PostMapping("/save")
    public ResponseEntity<MemberResponseDTO> create(@Valid @RequestBody MemberRequestDTO dto) {
        Member member = memberMapper.toEntity(dto);

        Member createdMember = memberService.save(member);

        MemberResponseDTO response = memberMapper.toDto(createdMember);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> findById(@PathVariable Long id) {
        Member member = memberService.findById(id);

        MemberResponseDTO response = memberMapper.toDto(member);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponseDTO>> findAll() {
        List<Member> members = memberService.findAll();

        // Lista vazia que irá receber os Members convertidos para dto
        List<MemberResponseDTO> membersDto = new ArrayList<>();

        for (Member member : members) {
            MemberResponseDTO memberDto = memberMapper.toDto(member);
            membersDto.add(memberDto);
        }
        return ResponseEntity.status(HttpStatus.OK).body(membersDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> updateMember(@PathVariable Long id, @Valid @RequestBody MemberRequestDTO dto) {
        Member member = memberMapper.toEntity(dto);

        Member updatedMember = memberService.update(id, member);

        MemberResponseDTO response = memberMapper.toDto(updatedMember);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        memberService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
