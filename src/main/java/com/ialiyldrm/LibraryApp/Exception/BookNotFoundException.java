package com.ialiyldrm.LibraryApp.Exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException() {
        super();
    }

    public BookNotFoundException(String message){
        super((message));
    }
}
