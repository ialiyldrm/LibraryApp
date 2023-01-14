package com.ialiyldrm.LibraryApp.Requests;

import lombok.Data;

@Data
public class AuthorCreateRequest {

    String authorName;
    String about;
}
