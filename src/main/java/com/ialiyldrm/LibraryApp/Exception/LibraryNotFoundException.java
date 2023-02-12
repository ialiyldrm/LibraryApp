package com.ialiyldrm.LibraryApp.Exception;

public class LibraryNotFoundException extends RuntimeException{
    public LibraryNotFoundException() {
        super();
    }

    public LibraryNotFoundException(String message) {
        super(message);
    }
}
