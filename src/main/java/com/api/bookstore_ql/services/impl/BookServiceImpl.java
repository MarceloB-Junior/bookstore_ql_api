package com.api.bookstore_ql.services.impl;

import com.api.bookstore_ql.dtos.BookInput;
import com.api.bookstore_ql.exceptions.AuthorNotFoundException;
import com.api.bookstore_ql.exceptions.BookAlreadyExistsException;
import com.api.bookstore_ql.exceptions.BookNotFoundException;
import com.api.bookstore_ql.models.BookModel;
import com.api.bookstore_ql.repositories.AuthorRepository;
import com.api.bookstore_ql.repositories.BookRepository;
import com.api.bookstore_ql.services.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    @Transactional
    public BookModel save(BookInput input) {
        var author = authorRepository.findById(input.authorId())
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + input.authorId()));

        if(bookRepository.existsByTitleAndAuthor(input.title(), author)){
            throw new BookAlreadyExistsException("Book '" + input.title() + "' already exists for this author.");
        }
        var book = new BookModel();
        book.setTitle(input.title());
        book.setPublisher(input.publisher());
        book.setAuthor(author);

        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public Long deletebyId(Long id) {
        if(!bookRepository.existsById(id)){
            throw  new BookNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
        return id;
    }

}
