package com.api.bookstore_ql.controllers;

import com.api.bookstore_ql.dtos.BookInput;
import com.api.bookstore_ql.models.BookModel;
import com.api.bookstore_ql.services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @MutationMapping
    public BookModel addBook(@Argument("book") @Valid BookInput book){
        return bookService.save(book);
    }

    @MutationMapping
    public Long deleteBook(@Argument Long id){
        return bookService.deletebyId(id);
    }
}