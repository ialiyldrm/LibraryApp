package com.ialiyldrm.LibraryApp.Responses;

import com.ialiyldrm.LibraryApp.Entities.User;
import lombok.Data;

@Data
public class UserResponse {

    Long id;
    String userName;

    public  UserResponse(User entity){
        this.id=entity.getId();
        this.userName=entity.getUserName();
    }
}
