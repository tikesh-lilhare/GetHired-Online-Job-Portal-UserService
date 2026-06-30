package com.example.UserService.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
public class AuthResponse {
    private Long id;

    private String token;

    private String role;

    private String name;

}
