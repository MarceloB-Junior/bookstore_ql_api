package com.api.bookstore_ql.services.impl;

import com.api.bookstore_ql.dtos.AuthorInput;
import com.api.bookstore_ql.exceptions.AuthorAlreadyExistsException;
import com.api.bookstore_ql.exceptions.AuthorNotFoundException;
import com.api.bookstore_ql.models.AuthorModel;
import com.api.bookstore_ql.repositories.AuthorRepository;
import com.api.bookstore_ql.services.AuthorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    @Transactional
    public AuthorModel save(AuthorInput input) {
        if(authorRepository.existsByName(input.name())){
            throw new AuthorAlreadyExistsException("Author '"+ input.name() +"' already exists.");
        }
        var author = new AuthorModel();
        author.setName(input.name());
        return authorRepository.save(author);
    }

    @Override
    public List<AuthorModel> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public AuthorModel findById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: "+ id));
    }

    @Override
    @Transactional
    public Long deleteById(Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: "+ id));
        author.getBooks().clear();
        authorRepository.deleteById(id);
        return id;
    }

}