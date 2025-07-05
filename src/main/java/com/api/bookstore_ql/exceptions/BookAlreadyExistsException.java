package com.api.bookstore_ql.exceptions;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String message){
        super(message);
    }
}
