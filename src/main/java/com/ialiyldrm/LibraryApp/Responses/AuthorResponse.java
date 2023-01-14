package com.ialiyldrm.LibraryApp.Responses;

import com.ialiyldrm.LibraryApp.Entities.Author;
import lombok.Data;

@Data
public class AuthorResponse {

    Long id;
    String authorName;
    String about;

    public AuthorResponse(Author entity) {
        this.id = entity.getId();
        this.authorName = entity.getAuthorName();
        this.about = entity.getAbout();
    }
}
