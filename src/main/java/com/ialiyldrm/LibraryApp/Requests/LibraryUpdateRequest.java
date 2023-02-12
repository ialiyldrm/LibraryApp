package com.ialiyldrm.LibraryApp.Requests;

import com.ialiyldrm.LibraryApp.Entities.User;
import lombok.Data;

@Data
public class LibraryUpdateRequest {

    String libraryName;
    User user;

}
