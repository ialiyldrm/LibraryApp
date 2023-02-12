package com.ialiyldrm.LibraryApp.Responses;

import com.ialiyldrm.LibraryApp.Entities.Book;
import com.ialiyldrm.LibraryApp.Entities.Library;
import com.ialiyldrm.LibraryApp.Entities.User;
import lombok.Data;

@Data
public class LibraryResponse {
    Long id;
    String libraryName;
    User user;
    Book book;

    public LibraryResponse(Library entity) {
        this.id =entity.getId();
        this.book=entity.getBook();
        this.user=entity.getUser();
        this.libraryName=entity.getLibraryName();
    }
}
