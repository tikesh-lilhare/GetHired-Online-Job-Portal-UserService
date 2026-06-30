package com.example.UserService.Service;

import com.example.UserService.DTO.*;
import com.example.UserService.Entity.User;
import com.example.UserService.Exception.EmailAlreadyExistsException;
import com.example.UserService.Exception.UserNotFoundException;
import com.example.UserService.Repository.UserRepo;
import com.example.UserService.Security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    @Override
    public UserRes register(RegisterReq request) {

        if(userRepo.findByEmail(request.getEmail())
                .isPresent()) {

            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        User savedUser = userRepo.save(user);

        return new UserRes(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getRole().name()
        );
    }

    @Override
    public List<UserRes> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(user -> new UserRes(
                                user.getId(),
                                user.getName(),
                                user.getEmail(),
                                user.getRole().name()
                        ))
                .toList();
    }
    @Override
    public UserRes getUserById(
            Long id) {

        User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(
                                                "User not found"));

        return new UserRes(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name()
        );
    }
    @Override
    public AuthResponse login(
            LoginReq request) {

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            System.out.println("AUTH SUCCESS");

        } catch (Exception e) {

            System.out.println("ERROR TYPE = "
                    + e.getClass().getName());

            System.out.println("ERROR MESSAGE = "
                    + e.getMessage());

            e.printStackTrace();

            throw e;
        }

        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(

                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user =
                userRepo.findByEmail(
                                request.getEmail()
                        )
                        .orElseThrow(
                                () ->
                                        new UserNotFoundException(
                                                "User not found"
                                        )
                        );

        String token =
                jwtUtil.generateToken(
                        user.getEmail(),
                        user.getRole().name()
                );

        return new AuthResponse(
                user.getId(),
                token,
                user.getRole().name(),
                user.getName()
        );
    }
    @Override
    public UserProfileResponse getProfile(Long userId) {

        User user =
                userRepo.findById(userId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found"
                                )
                        );

        return UserProfileResponse.builder()

                .id(user.getId())

                .name(user.getName())

                .email(user.getEmail())

                .role(user.getRole().name())

                .phone(user.getPhone())

                .location(user.getLocation())

                .education(user.getEducation())

                .experience(user.getExperience())

                .skills(user.getSkills())

                .about(user.getAbout())

                .profileImage(user.getProfileImage())

                .resumeUrl(user.getResumeUrl())

                .build();

    }
    @Override
    public UserProfileResponse updateProfile(

            Long userId,

            UpdateProfileRequest request) {

        User user =
                userRepo.findById(userId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found"
                                )
                        );

        user.setName(
                request.getName()
        );

        user.setPhone(
                request.getPhone()
        );

        user.setLocation(
                request.getLocation()
        );

        user.setEducation(
                request.getEducation()
        );

        user.setExperience(
                request.getExperience()
        );

        user.setSkills(
                request.getSkills()
        );

        user.setAbout(
                request.getAbout()
        );

        User saved =
                userRepo.save(user);

        return UserProfileResponse.builder()

                .id(saved.getId())

                .name(saved.getName())

                .email(saved.getEmail())

                .role(saved.getRole().name())

                .phone(saved.getPhone())

                .location(saved.getLocation())

                .education(saved.getEducation())

                .experience(saved.getExperience())

                .skills(saved.getSkills())

                .about(saved.getAbout())

                .profileImage(saved.getProfileImage())

                .resumeUrl(saved.getResumeUrl())

                .build();

    }
}
