package com.api.bookstore_ql.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String message){
        super(message);
    }
}
