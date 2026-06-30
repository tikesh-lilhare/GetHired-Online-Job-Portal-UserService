package com.example.UserService.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileResponse {
    private Long id;

    private String name;

    private String email;

    private String role;

    private String phone;

    private String location;

    private String education;

    private String experience;

    private String skills;

    private String about;

    private String profileImage;

    private String resumeUrl;
}
