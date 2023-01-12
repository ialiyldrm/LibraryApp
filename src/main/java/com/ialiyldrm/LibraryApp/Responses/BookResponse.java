package com.ialiyldrm.LibraryApp.Responses;

import com.ialiyldrm.LibraryApp.Entities.Book;
import lombok.Data;

import java.util.Date;

@Data
public class BookResponse {
    Long id;
    Long userId;
    String userName;
    String name;
    boolean isRead;
    String edition;
    String commit;
    Date addDate;
    Date readDate;

    public BookResponse(Book entity) {
        this.id=entity.getId();
        this.userId=entity.getUser().getId();
        this.userName=entity.getUser().getUserName();
        this.name=entity.getName();
        this.isRead=entity.isRead();
        this.edition=entity.getEdition();
        this.commit=entity.getCommit();
        this.addDate=entity.getAddDate();
        this.readDate=entity.getReadDate();
    }
}
