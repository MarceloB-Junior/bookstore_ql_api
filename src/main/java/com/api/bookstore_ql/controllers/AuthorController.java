package com.api.bookstore_ql.controllers;

import com.api.bookstore_ql.dtos.AuthorInput;
import com.api.bookstore_ql.models.AuthorModel;
import com.api.bookstore_ql.services.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @QueryMapping
    public List<AuthorModel> authors(){
        return authorService.findAll();
    }

    @QueryMapping
    public AuthorModel authorById(@Argument Long id){
        return authorService.findById(id);
    }

    @MutationMapping
    public AuthorModel addAuthor(@Argument("author") @Valid AuthorInput author){
        return authorService.save(author);
    }

    @MutationMapping
    public Long deleteAuthor(@Argument Long id){
        return authorService.deleteById(id);
    }
}