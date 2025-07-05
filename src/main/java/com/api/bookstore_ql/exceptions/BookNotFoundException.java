package com.api.bookstore_ql.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message){
        super(message);
    }
}
