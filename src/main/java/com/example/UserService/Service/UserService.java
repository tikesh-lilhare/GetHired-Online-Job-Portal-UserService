package com.example.UserService.Service;

import com.example.UserService.DTO.*;

import java.util.List;

public interface UserService {
    UserRes register(RegisterReq request);

    List<UserRes> getAllUsers();

    UserRes getUserById(Long id);

    AuthResponse login(
            LoginReq request);

    UserProfileResponse getProfile(Long userId);

    UserProfileResponse updateProfile(
            Long userId,
            UpdateProfileRequest request
    );
}
