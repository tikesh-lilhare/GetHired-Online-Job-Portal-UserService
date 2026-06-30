package com.example.UserService.DTO;

import lombok.Data;

@Data
public class LoginReq {
    private String email;
    private String password;
}
