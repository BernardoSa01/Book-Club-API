package com.example.bookclub.repository;

import com.example.bookclub.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Consulta para verificar se o livro está em posse de algum membro
    boolean existsByBorrowedById(Long memberId);

    // Retorna todos os livros emprestados por determinado membro
    List<Book> findByBorrowedById(Long memberId);
}
