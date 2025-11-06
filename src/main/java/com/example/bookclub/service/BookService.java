package com.example.bookclub.service;

import com.example.bookclub.model.Book;
import com.example.bookclub.model.BookStatus;
import com.example.bookclub.model.Member;
import com.example.bookclub.model.MembershipType;
import com.example.bookclub.repository.BookRepository;
import com.example.bookclub.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;


    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
    }

    public List<Book> findAll() {
        List<Book> books = bookRepository.findAll();

        if (books.isEmpty()) {
            throw new EntityNotFoundException("Nenhum livro encontrado");
        }

        return books;
    }

    public Book update(Long id, Book book) {
        Book foundBook = findById(id);

        // Alterando os atributos com set + get
        foundBook.setTitle(book.getTitle());
        foundBook.setAuthor(book.getAuthor());
        foundBook.setGenre(book.getGenre());
        foundBook.setBookStatus(book.getBookStatus());
        foundBook.setBorrowedBy(book.getBorrowedBy());

        // Salva as alterações no banco
        return bookRepository.save(foundBook);
    }

    public void delete(Long id) {
        Book foundBook = findById(id);

        if (foundBook.getBookStatus() == BookStatus.BORROWED) {
            throw new IllegalStateException("Não é possível excluir. Livro emprestado.");
        }

        bookRepository.delete(foundBook);
    }


    // Empréstimo de livros
    public Book borrowBook(Long id, Long memberId) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Membro não encontrado"));

        if (book.getBookStatus() != BookStatus.AVAILABLE) {
            throw new IllegalStateException("Livro indisponível para empréstimo");
        }

        int borrowedCount = member.getBooks().size();

        // Define por regra que MemberShip PREMIUM = até 5 livros. MemberShip REGULAR = até 3 livros
        int booksLimit = member.getMembershipType() == MembershipType.PREMIUM ? 5 : 3;

        if (borrowedCount >= booksLimit) {
            throw new IllegalStateException("Limite de empréstimos atingido para a categoria do membro");
        }

        // Setando status e datas
        book.setBorrowedBy(member);
        book.setBookStatus(BookStatus.BORROWED);
        book.setBorrowDate(LocalDate.now());
        book.setDueDate(LocalDate.now().plusDays(14));

        return bookRepository.save(book);
    }

    public Book returnBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));


        if (book.getBookStatus() != BookStatus.BORROWED) {
            throw new IllegalStateException("Erro. Livro não se encontra emprestado");
        }

        // Alteração de status para devolução do livro
        book.setBorrowedBy(null);
        book.setBookStatus(BookStatus.AVAILABLE);
        book.setBorrowDate(null);
        book.setDueDate(null);

        return bookRepository.save(book);
    }


}
