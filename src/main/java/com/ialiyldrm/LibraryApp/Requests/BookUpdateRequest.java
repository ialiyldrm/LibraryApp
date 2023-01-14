package com.ialiyldrm.LibraryApp.Requests;

import lombok.Data;

import java.util.Date;

@Data
public class BookUpdateRequest {
    String name;
    boolean isRead;
    String commit;
    String edition;
    Date addDate;
    Date readDate;
    Long authorId;
}
