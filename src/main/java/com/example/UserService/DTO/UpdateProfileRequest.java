package com.example.UserService.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateProfileRequest {
    private String name;

    private String phone;

    private String location;

    private String education;

    private String experience;

    private String skills;

    private String about;
}
