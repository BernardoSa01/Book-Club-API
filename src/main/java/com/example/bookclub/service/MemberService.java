package com.example.bookclub.service;

import com.example.bookclub.model.Book;
import com.example.bookclub.model.Member;
import com.example.bookclub.repository.BookRepository;
import com.example.bookclub.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BookRepository bookRepository;

    public Member save(Member member){
        // Verificação para evitar duplicidade de e-mail
        if (memberRepository.existsByEmail(member.getEmail())) {
            throw new IllegalArgumentException("Este e-mail já está em uso.");
        }
        return memberRepository.save(member);
    }

    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Membro não encontrado"));
    }

    public List<Member> findAll() {
        List<Member> members = memberRepository.findAll();

        if (members.isEmpty()) {
            throw new EntityNotFoundException("Nenhum membro encontrado");
        }
        return members;
    }

    public List<Book> findBooksByMemberId(Long memberId) {
        // Verifica se o membro existe
        findById(memberId);

        // Retorna todos os livros emprestados por esse membro
        return bookRepository.findByBorrowedById(memberId);
    }

    public Member update(Long id, Member member) {
        // Buscando o membro pelo id
        Member foundMember = findById(id);

        // Alterando os atributos com set + get
        foundMember.setName(member.getName());
        foundMember.setEmail(member.getEmail());
        foundMember.setPassword(member.getPassword());
        foundMember.setMembershipType(member.getMembershipType());

        // Salva as alterações realizadas
        return memberRepository.save(foundMember);
    }

    public void delete(Long id) {
        Member member = findById(id);

        if (bookRepository.existsByBorrowedById(id)) {
            throw new IllegalStateException("Não é possível excluir o membro. Existem livros emprestados em seu registro.");
        }

        memberRepository.delete(member);
    }

}


