package com.api.bookstore_ql.exceptions;

public class AuthorAlreadyExistsException extends RuntimeException {
    public AuthorAlreadyExistsException(String message){
        super(message);
    }
}
