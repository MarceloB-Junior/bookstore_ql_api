package com.api.bookstore_ql.services;

import com.api.bookstore_ql.dtos.BookInput;
import com.api.bookstore_ql.models.BookModel;

public interface BookService {
    BookModel save(BookInput input);
    Long deletebyId(Long id);
}
