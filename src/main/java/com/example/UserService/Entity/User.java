package com.example.UserService.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "userDetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String phone;

    private String location;

    private String education;

    private String experience;

    @Column(length = 1000)
    private String skills;

    @Column(length = 2000)
    private String about;

    private String profileImage;

    private String resumeUrl;
}
