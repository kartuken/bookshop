package org.krytev.bookstore.dtos;

import lombok.Data;

@Data
public class UserRegDto {

    private String email;
    private String password;
    private String fio;
    private String address;

}
