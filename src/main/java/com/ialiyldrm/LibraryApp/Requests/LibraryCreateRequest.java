package com.ialiyldrm.LibraryApp.Requests;

import com.ialiyldrm.LibraryApp.Entities.User;
import lombok.Data;

@Data
public class LibraryCreateRequest {
    String libraryName;
    User user;
}
