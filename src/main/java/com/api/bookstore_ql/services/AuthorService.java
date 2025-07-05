package com.api.bookstore_ql.services;

import com.api.bookstore_ql.dtos.AuthorInput;
import com.api.bookstore_ql.models.AuthorModel;

import java.util.List;

public interface AuthorService {
    AuthorModel save(AuthorInput input);
    List<AuthorModel> findAll();
    AuthorModel findById(Long id);
    Long deleteById(Long id);
}
